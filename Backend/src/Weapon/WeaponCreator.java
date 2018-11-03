package Weapon;

import Weapon.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author S.A. Tanja
 */
public class WeaponCreator implements Iterable<Weapon> {

    // Collection of all the supported weapons
    private List<Weapon> allWeapons;

    public WeaponCreator() {
        Weapon foil = new Foil();
        Weapon epee = new Epee();
        Weapon sabre = new Sabre();
        allWeapons = new ArrayList<>();
        allWeapons.add(foil);
        allWeapons.add(epee);
        allWeapons.add(sabre);
    }

    /**
     * Creates a weapon from a string
     * @param w The input weapon
     * @return The weapon that matches {@code w}
     * @throws IllegalArgumentException If {@code w} is not a valid weapon
     */
    public Weapon createWeapon(String w) throws IllegalArgumentException {
        switch (w) {
            case "epee":
                return new Epee();
            case "foil":
                return new Foil();
            case "sabre":
                return new Sabre();
            default:
                throw new IllegalArgumentException("Weapon " + w + " is not a valid weapon");
        }
    }

    /**
     * Iterator to go over all weapons, i.e. for creating a ladder for every weapon
     * @return Iterator of all the weapons
     */
    @Override
    public Iterator<Weapon> iterator() {
        return allWeapons.iterator();
    }
}
