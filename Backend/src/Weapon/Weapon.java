package Weapon;

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

}
