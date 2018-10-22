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


    @Test
    public void compareTo() {
        Random randomPosition = new Random();
        String name = "a";
        Weapon foil = new Foil();

        List<Integer> positions = new ArrayList<>();
        int size = 100;
        for (int i = 0; i < size; i++) {
            positions.add(i);
        }

        // Create a randomly ordered ranking with distinct positions (0 to size -1)
        List<Fencer> ranking = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Fencer fencer = new Fencer(name, foil);
            int index = randomPosition.nextInt(positions.size());
            int position = positions.remove(index);
            fencer.setMMR(position);
            ranking.add(fencer);
        }


        // Sort it and verify its correctness
        Collections.sort(ranking);
        int mmr = ranking.get(0).getMMR();
        for (Fencer fencer : ranking) {
            assertTrue(mmr <= fencer.getMMR());
            mmr = fencer.getMMR();
        }
    }
}