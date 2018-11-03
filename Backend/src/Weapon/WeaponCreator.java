package Weapon;

import Weapon.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeaponCreator implements Iterable<Weapon> {

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

    @Override
    public Iterator<Weapon> iterator() {
        return allWeapons.iterator();
    }
}
