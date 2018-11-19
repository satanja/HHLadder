package Records;

import ELO.ELOFencer;
import Weapon.Weapon;
import org.json.*;

/**
 * @author S.A. Tanja
 */
public class Fencer implements ELOFencer {

    // The name of the fencer
    private String name;

    // The weapon the fencer uses
    private Weapon weapon;

    // The match making rating (mmr) of the fencer
    private int mmr;

    // The number of bouts the fencer fenced
    private int boutsFenced;

    // Whether to show the MMR in the printed ranking
    private boolean isHiddenMMR;

    /**
     * Create a fencer with its MMR not hidden
     * @param name The name of the fencer
     * @param weapon The weapon of the fencer
     */
    public Fencer(String name, Weapon weapon) {
        this(name, weapon, false);
    }

    /**
     * Create a fencer with its MMR hidden or not
     * @param name The name of the fencer
     * @param weapon The weapon of the fencer
     * @param isHiddenMMR Whether to hide the MMR of the fencer
     */
    public Fencer(String name, Weapon weapon, boolean isHiddenMMR) {
        this.name = name;
        this.weapon = weapon;
        boutsFenced = 0;
        this.isHiddenMMR = isHiddenMMR;
    }

    /**
     * Gets the name of the fencer
     * @return {@code this.name}
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the weapon of the fencer
     * @return {@code this.weapon}
     */
    public Weapon getWeapon() {
        return weapon;
    }


    @Override
    public int getBoutsFenced() {
        return boutsFenced;
    }


    @Override
    public void increaseBoutsFenced() {
        boutsFenced++;
    }

    @Override
    public int getMMR() {
        return mmr;
    }

    @Override
    public void setMMR(int newMMR) {
        this.mmr = newMMR;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fencer) {
            Fencer fencer = (Fencer) obj;
            boolean sameName = fencer.getName().equals(name);
            boolean sameWeapon = fencer.getWeapon().equals(weapon);
            return sameName && sameWeapon;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name);
        if (isHiddenMMR) {
            return result.toString();
        }
        result.append(" ");
        result.append(mmr);
        return result.toString();
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("id", 0); //TODO implement ids
        json.put("name", name);
        json.put("MMR", mmr);
        return json;
    }
}
