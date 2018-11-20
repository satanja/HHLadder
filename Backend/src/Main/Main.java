package Main;

import ELO.*;
import IO.*;
import Ladder.*;
import Weapon.*;
import org.json.JSONObject;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author S.A. Tanja
 */
public class Main {


    // Only contains one ladder per weapon
    private List<Ladder> ladders;

    public Main(ELOManager eloManager) {
        ladders = new ArrayList<>();
        addAllLadders(eloManager);
        IO io = new IO(this);
        String host = "0.0.0.0";

        int port = 4242;
        WebSocketIO server = new WebSocketIO(this, new InetSocketAddress(host, port));

        Thread IOThread = new Thread(io, "io");
        IOThread.start();
        Thread serverThread = new Thread(server, "server");
        serverThread.start();
    }

    /**
     * Adds a fencer to the ladder of the weapon
     * @param weapon The weapon the fencer would like to fence with
     * @param name The name of the fencer
     * @return true if the fancer has been added, false if not
     */
    public synchronized boolean addFencer(Weapon weapon, String name) {
        Ladder ladder = getLadder(weapon);
        return ladder.addFencer(name);
    }

    /**
     * Processes the bout for two fencers and their scores
     * @param weapon The weapon the fencers fenced on
     * @param nameA The name of the first fencer
     * @param nameB The name of the second fencer
     * @param scoreA The number of touches of the first fencer
     * @param scoreB The number of touches of the second fencer
     */
    public void processMatch(Weapon weapon,  String nameA, String nameB, int scoreA, int scoreB) {
        Ladder ladder = getLadder(weapon);
        ladder.processMatch(nameA, nameB, scoreA, scoreB);
    }

    /**
     * Gets the string representation of the ladder with the right weapon
     * @param weapon The weapon of the ladder
     * @return The string representation of the ladder with the right weapon
     */
    public String ladderToString(Weapon weapon) {
        return getLadder(weapon).toString();
    }

    /**
     * Gets the JSON representation of the ladder with the right weapon
     * @param weapon The weapon of the ladder
     * @return The JSON representation of the ladder with the right weapon
     */
    public synchronized JSONObject ladderToJSON(Weapon weapon) {
        return getLadder(weapon).toJSON();
    }

    /**
     * Gets a JSON representation of all the ladders
     * @return The JSON representation of all the ladders
     */
    public synchronized JSONObject laddersToJSON() {
        JSONObject json = new JSONObject();
        ArrayList<JSONObject> ladderJSONs = new ArrayList<>();

        WeaponCreator creator = new WeaponCreator();
        for (Weapon weapon : creator) {
            JSONObject ladderJSON = getLadder(weapon).toJSON();
            ladderJSONs.add(ladderJSON);
        }
        json.put("ladders", ladderJSONs);

        return json;
    }

    /**
     * Gets the ladder for the appropriate weapon
     * @param weapon The weapon of the ladder
     * @return The ladder of the weapon
     */
    private Ladder getLadder(Weapon weapon) {
        for (Ladder ladder : ladders) {
            if (ladder.getWeapon().equals(weapon)) {
                return ladder;
            }
        }
        return null; // should never be executed
    }

    /**
     * All the ladders to support (one per weapon)
     * @param eloManager The ELOManager for the ladders
     */
    private void addAllLadders(ELOManager eloManager) {
       WeaponCreator creator = new WeaponCreator();
       for (Weapon weapon : creator) {
           ladders.add(new Ladder(weapon, eloManager));
       }
    }

    public static void main(String[] args) {
        ELOManager eloManager;
        if (args.length > 0) {
            switch (args[0]) {
                case "-Ss":
                    // SuperSimpleELOManager
                    eloManager = new SuperSimpleELOManager();
                    break;
                case "-S":
                    // SimpleELOManager
                    eloManager = new SimpleELOManager();
                    break;
                default:
                    eloManager = new SimpleELOManager();
                    break;
            }
        } else {
            eloManager = new SimpleELOManager();
        }
        new Main(eloManager);
    }
}
