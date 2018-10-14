import java.util.ArrayList;
import java.util.List;

public class Ladder {

    /*
     * Rep. inv.:
     * - All {@code Fencer}s in {@code fencers} use the weapon {@code weapon}
     * - The index of the fencer in {@code fencers} is their position on the ladder.
     */

    // All the fencers in the ladder
    private List<Fencer> fencers;

    // The weapon of the ladder
    private Weapon weapon;


    public Ladder(Weapon weapon) {
        this.weapon = weapon;
        fencers = new ArrayList<>();
    }

    /**
     * Adds a {@code Fencer} to the ladder if:
     * <ul>
     *     <li>The {@code Fencer} uses the same weapon as the {@code Ladder}</li>
     *     <li>There does not already exist a {@code Fencer} with the same name</li>
     * </ul>
     * @return true when the {@code fencer} has the same weapon and a fencer with the same name does not exist.
     */
    public boolean addFencer(Fencer fencer) {
        if (fencerHasSameWeapon(fencer) && !containsFencer(fencer)) {
            fencers.add(fencer);
            return true;
        }
        return false;
    }

    private boolean fencerHasSameWeapon(Fencer fencer) {
        return fencer.getWeapon().equals(weapon);
    }

    private boolean containsFencer(Fencer fencer) {
        // TODO implement
        return false;
    }
}
