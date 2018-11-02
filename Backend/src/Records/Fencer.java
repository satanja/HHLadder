package Records;

import ELO.ELOFencer;
import Weapon.Weapon;

import java.util.Comparator;

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

    // To sort the ladder based on Fencer's MMR
    public static Comparator<Fencer> ELOComparator = (a, b) -> a.getMMR() - b.getMMR();
}
