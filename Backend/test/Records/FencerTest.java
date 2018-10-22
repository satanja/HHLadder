package Records;

import Weapon.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class FencerTest {

    private Fencer fencer;

    private void setUp(String name, Weapon weapon) {
        fencer = new Fencer(name, weapon);
    }

    @Test
    public void getName() {
        Weapon epee = new Epee();
        String name = "stefan";
        setUp(name, epee);
        assertEquals(name, fencer.getName());
    }

    @Test
    public void getWeapon() {
        Weapon epee = new Epee();
        String name = "stefan";
        setUp(name, epee);
        assertEquals(epee, fencer.getWeapon());
    }

    @Test
    public void getMMR() {
        Weapon foil = new Foil();
        setUp("Hidde", foil);
        assertEquals(0, fencer.getMMR());
    }

    @Test
    public void setMMR() {
        Weapon foil = new Foil();
        setUp("Hidde", foil);
        int mmr = 9001;
        fencer.setMMR(mmr);
        assertEquals(mmr, fencer.getMMR());
    }

}