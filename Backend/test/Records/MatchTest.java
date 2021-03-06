package Records;

import ELO.ELOFencer;
import Records.Fencer;
import Records.Match;
import Weapon.Epee;
import Weapon.Foil;
import Weapon.Weapon;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {

    private Match match;

    private void setUp(Fencer a, Fencer b, int scoreA, int scoreB) {
        match = new Match(a, b, scoreA, scoreB);
    }

    private void checkWinner(Fencer winner) {
        assertEquals(winner, match.getWinner());
    }

    private void checkLoser(Fencer loser) {
        assertEquals(loser, match.getLoser());
    }

    @Test
    public void getters() {
        Weapon epee = new Epee();
        Fencer bob = new Fencer("bob", epee);
        Fencer stefan = new Fencer("stefan", epee);
        int scoreBob = 50;
        int scoreStefan = 0;
        setUp(bob, stefan, scoreBob, scoreStefan);
        checkWinner(bob);
        checkLoser(stefan);
    }

    @Test
    public void getters2() {
        Weapon epee = new Epee();
        Fencer bob = new Fencer("bob", epee);
        Fencer stefan = new Fencer("stefan", epee);
        int scoreBob = 5;
        int scoreStefan = 15;
        setUp(bob, stefan, scoreBob, scoreStefan);
        checkWinner(stefan);
        checkLoser(bob);
    }

    private void checkExceptionWinner() {
        try {
            ELOFencer winner = match.getWinner();
            fail();
        } catch (IllegalStateException e) {
            assertTrue(true);
        }
    }

    private void checkExceptionLoser() {
        try {
            ELOFencer loser = match.getLoser();
            fail();
        } catch (IllegalStateException e) {
            assertTrue(true);
        }
    }

    // match needs to update the number of bouts of the fencers
    @Test
    public void getBoutsFencedNoMatches() {
        Weapon epee = new Epee();
        String name = "stefan";
        Fencer stefan = new Fencer(name, epee);
        assertEquals(0, stefan.getBoutsFenced());
    }

}