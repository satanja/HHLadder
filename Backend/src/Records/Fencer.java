package Records;

import ELO.ELOFencer;
import Weapon.Weapon;

/**
 * @author S.A. Tanja
 *
 *
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

    public Fencer(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
        boutsFenced = 0;
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

}
