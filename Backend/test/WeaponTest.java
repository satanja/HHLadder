import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {

    private void checkIsEqual(Weapon weapon1, Weapon weapon2, boolean expected) {
        assertEquals(expected, weapon1.equals(weapon2));
    }

    // Reflexive tests are also included
    @Test
    public void equalsSameObject() {
        Weapon epee1 = new Epee();
        Weapon epee2 = epee1;
        checkIsEqual(epee1, epee2, true);
        checkIsEqual(epee2, epee1, true);
    }

    @Test
    public void equalsDifferentObject() {
        Weapon epee1 = new Epee();
        Weapon epee2 = new Epee();
        checkIsEqual(epee1, epee2, true);
        checkIsEqual(epee2, epee1, true);
    }

    @Test
    public void equalsDifferentWeapon() {
        Weapon epee = new Epee();
        Weapon foil = new Foil();
        checkIsEqual(epee, foil, false);
        checkIsEqual(foil, epee, false);
    }

    // Test the transitive property
    @Test
    public void equalsTransitiveDifferentWeapon() {
        Weapon epee = new Epee();
        Weapon foil = new Foil();
        Weapon sabre = new Sabre();

        boolean result1 = epee.equals(foil);
        assertFalse(result1);

        boolean result2 = foil.equals(sabre);
        assertFalse(result2);

        boolean result3 = epee.equals(sabre);
        assertEquals(result3, result1 && result2);
    }

}