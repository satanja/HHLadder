package IO;

import Main.Main;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.json.*;
import Weapon.*;

public class WebSocketIO extends WebSocketServer {

    private Main main;

    public WebSocketIO(Main main, InetSocketAddress address) {
        super(address);
        this.main = main;
    }

    private JSONObject getJSONLadder(Weapon weapon) {
        return main.ladderToJSON(weapon);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("Connected");
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("Closed");
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        JSONObject json = new JSONObject(s);
        switch (json.getString("command")) {
            case "ladders":
                webSocket.send(main.laddersToJSON().toString());
                break;
            case "add":
                add(json);
                break;
            case "ladder":
                //TODO implement properly
                Weapon epee = new Epee();
                webSocket.send(getJSONLadder(epee).toString());
                break;
        }
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.err.println("an error occurred on connection " + webSocket.getRemoteSocketAddress()  + ":" + e);
    }

    @Override
    public void onStart() {
        System.out.println("server started successfully");
    }


    /**
     * Parses the JSON message for the add command
     * @param addMessage The JSON message of the add command
     */
    private void add(JSONObject addMessage) {
        String name = addMessage.getString("name");
        JSONArray weapons = addMessage.getJSONArray("ladders");
        for (Weapon weapon : getWeapons(weapons)) {
            main.addFencer(weapon, name);
        }
    }

    /**
     * Converts all the weapon strings in a JSON array to Weapons
     * @param weaponsJson The JSON array of weapon strings
     * @return A collection of all the weapons present
     */
    private Collection<Weapon> getWeapons(JSONArray weaponsJson) {
        ArrayList<Weapon> weapons = new ArrayList<Weapon>();

        WeaponCreator creator = new WeaponCreator();
        for (Object weaponObj : weaponsJson.toList()) {
            HashMap<String, String> map = (HashMap<String, String>) weaponObj;
            String weapon = map.get("name");
            weapons.add(creator.createWeapon(weapon));
        }

        return weapons;
    }

    /**
     * Example method for sending JSON messages to the frontend
     * @param webSocket The WebSocket connection
     */
    public void sendExampleJSON(WebSocket webSocket) {
        JSONObject json = new JSONObject();
        json.put("success", true);
        String jsonMessage = json.toString();
        webSocket.send(jsonMessage);
    }
}
