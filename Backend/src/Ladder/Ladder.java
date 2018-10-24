package Ladder;

import ELO.ELOManager;
import Records.Fencer;
import Weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    /*
     * Rep. inv.:
     * - All {@code Fencer}s in {@code fencers} use the weapon {@code weapon}
     * - {@code fencers} is sorted by MMR of the fencers
     */

    // All the fencers in the ladder
    private List<Fencer> fencers;

    // The weapon of the ladder
    private Weapon weapon;

    // The ELO system of this ladder
    private ELOManager eloManager;

    public Ladder(Weapon weapon, ELOManager eloManager) {
        this.weapon = weapon;
        fencers = new ArrayList<>();
        this.eloManager = eloManager;
    }

    /**
     * Adds a {@code Fencer} to the ladder if:
     * <ul>
     *     <li>The {@code Fencer} uses the same weapon as the {@code Ladder}</li>
     *     <li>There does not already exist a {@code Fencer} with the same name</li>
     * </ul>
     * Also sets the initial MMR of the fencer
     * @return true when the {@code fencer} has the same weapon and a fencer with the same name does not exist.
     */
    public boolean addFencer(Fencer fencer) {
        if (fencerHasSameWeapon(fencer) && !containsFencer(fencer)) {
            fencers.add(fencer);
            int initialMMR = eloManager.getInitialMMR(fencers.indexOf(fencer));
            fencer.setMMR(initialMMR);
            return true;
        }
        return false;
    }

    /**
     * Creates a match of two fencers, updates their MMR, and finally resorts the ladder ranking.
     * @param fencerA The first fencer
     * @param fencerB The second fencer
     * @param scoreA The number of touches fencerA made
     * @param scoreB The number of touches fencerB made
     * @throws IllegalArgumentException if (!fencers.contains(fencerA) || !fencers.contains(fencerB))
     */
    public void processMatch(String fencerA, String fencerB, int scoreA, int scoreB) throws IllegalArgumentException {
        // TODO implement
    }

    /**
     * Returns the victor of the ladder
     * @return The fencer at the head of the ranking
     */
    public Fencer getVictor() {
        // TODO implement
        return null;
    }

    private boolean fencerHasSameWeapon(Fencer fencer) {
        return fencer.getWeapon().equals(weapon);
    }

    private boolean containsFencer(Fencer fencer) {
        // TODO implement
        return false;
    }
}
