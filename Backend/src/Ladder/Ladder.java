package Ladder;

import ELO.ELOManager;
import Records.Fencer;
import Records.Match;
import Weapon.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.*;
public class Ladder {

    /*
     * Rep. inv.:
     * - All {@code Fencer}s in {@code ranking} use the weapon {@code weapon}
     * - {@code ranking} is sorted by MMR of the fencer
     */

    // All the ranking in the ladder
    private List<Fencer> ranking;

    // The weapon of the ladder
    private Weapon weapon;

    // The ELO system of this ladder
    private ELOManager eloManager;

    public Ladder(Weapon weapon, ELOManager eloManager) {
        this.weapon = weapon;
        ranking = new ArrayList<>();
        this.eloManager = eloManager;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Adds a {@code Fencer} to the ladder if the fencer is not already present in the ranking
     * Also sets the initial MMR of the fencer
     * @return true when the {@code fencer} has the same weapon and a fencer with the same name does not exist.
     */
    public boolean addFencer(String name) {
        if (!containsFencer(name)) {
            Fencer fencer = new Fencer(name, weapon, eloManager.isHiddenMMR());
            ranking.add(fencer);
            int initialMMR = eloManager.getInitialMMR(ranking.indexOf(fencer));
            fencer.setMMR(initialMMR);
            sort();
            return true;
        }
        return false;
    }

    /**
     * Creates a match of two ranking, updates their MMR, and finally resorts the ladder ranking.
     * @param nameA The name of the first fencer
     * @param nameB The name of the second fencer
     * @param scoreA The number of touches fencerA made
     * @param scoreB The number of touches fencerB made
     * @throws IllegalArgumentException if (!ranking.contains(fencerA) || !ranking.contains(fencerB))
     */
    public void processMatch(String nameA, String nameB, int scoreA, int scoreB) throws IllegalArgumentException {
        if (!containsFencer(nameA)) {
            throw fencerNotFound(nameA);
        }
        if (!containsFencer(nameB)) {
            throw fencerNotFound(nameB);
        }

        Fencer a = getFencer(nameA);
        Fencer b = getFencer(nameB);
        // a != null && b != null

        Match bout = new Match(a, b, scoreA, scoreB);
        a.increaseBoutsFenced();
        b.increaseBoutsFenced();
        eloManager.updateMMR(bout);
        sort();
    }

    /**
     * Uses the simple way to process a match
     * @param winner The winner of the bout
     * @param loser The loser of the bout
     */
    public void processSimpleMatch(String winner, String loser) {
        if (!containsFencer(winner)) {
            throw fencerNotFound(winner);
        }
        if (!containsFencer(loser)) {
            throw fencerNotFound(loser);
        }

        Fencer a = getFencer(winner);
        Fencer b = getFencer(loser);

        Match bout = new Match(a, b);
        a.increaseBoutsFenced();
        b.increaseBoutsFenced();
        eloManager.updateMMR(bout);
        sort();

    }

    /**
     * Returns the victor of the ladder
     * @return The fencer at the head of the ranking, or null if the ladder is empty
     */
    public Fencer getVictor() {
        if (ranking.size() == 0) {
            return null;
        } else {
            return ranking.get(0);
        }
    }

     /**
     * Whether there exists a fencer in the ranking with the same name
     * @param name The name of the fencer
     * @return true if there exists a fencer with the same name in the ranking
     */
    private boolean containsFencer(String name) {
        for (Fencer fencer : ranking) {
            if (fencer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the fencer with the same name in the ranking
     * @param name The name of the fencer
     * @return The fencer in the ranking with the same name if present, otherwise null
     */
    private Fencer getFencer(String name) {
        for (Fencer fencer : ranking) {
            if (fencer.getName().equals(name)) {
                return fencer;
            }
        }
        return null;
    }


    private IllegalArgumentException fencerNotFound(String name) {
        return new IllegalArgumentException("Fencer with name " + name + " is not in this ladder");
    }

    private void sort() {
        Collections.sort(ranking, eloManager.getComparator());
    }

    @Override
    public String toString() {
        toJSON(); //TODO remove
        StringBuilder result = new StringBuilder();
        result.append(weapon.toString());
        result.append(" ");
        result.append("ranking:");
        result.append("\n");
        for (Fencer fencer : ranking) {
            result.append(ranking.indexOf(fencer) + 1);
            result.append(". ");
            result.append(fencer.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        ArrayList<JSONObject> jsonFencer = new ArrayList<>();
        for (Fencer fencer : ranking) {
            jsonFencer.add(fencer.toJSON());
        }
        json.put("name", weapon.toString());
        json.put("fencers", jsonFencer);
        json.put("isHiddenMMR", eloManager.isHiddenMMR());
        return json;
    }
}
