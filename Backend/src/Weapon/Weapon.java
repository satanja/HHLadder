package Weapon;

/**
 * @author S.A. Tanja
 */
public abstract class Weapon {

    protected String weapon;

    private String getWeapon() {
        return weapon;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Weapon) {
            Weapon w = (Weapon) obj;
            return getWeapon().equals(w.getWeapon());
        }
        return false;
    }

    @Override
    public String toString() {
        return weapon;
    }

}
