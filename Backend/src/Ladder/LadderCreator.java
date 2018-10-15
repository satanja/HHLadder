package Ladder;

import ELO.ELOManager;
import Weapon.Epee;
import Weapon.Foil;
import Weapon.Sabre;
import Weapon.Weapon;

public class LadderCreator {

    /**
     * Creates a Ladder for a specific weapon
     * @param weapon The weapon to create a ladder for
     * @param eloManager The ELOManager of the ladder
     * @return A Ladder object with the right weapon.
     * @throws IllegalArgumentException if an invalid weapon type is entered
     */
    public Ladder createLadder(String weapon, ELOManager eloManager) throws IllegalArgumentException {
        Weapon weaponObj;
        switch (weapon) {
            case "foil":
                weaponObj = new Foil();
                break;
            case "sabre":
                weaponObj = new Sabre();
                break;
            case "epee":
                weaponObj = new Epee();
                break;
            default:
                throw new IllegalArgumentException("Weapon " + weapon + " is not recognized");
        }
        return new Ladder(weaponObj, eloManager);

    }

}
