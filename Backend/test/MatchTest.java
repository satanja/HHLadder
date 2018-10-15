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

    @Test
    public void invalidMatch() {
        Weapon foil = new Foil();
        Fencer lars = new Fencer("lars", foil);
        Fencer hidde = new Fencer("hidde", foil);
        int scoreLars = 5;
        int scoreHidde = 5;
        setUp(lars, hidde, scoreHidde, scoreLars);
        checkExceptionWinner();
        checkExceptionLoser();
    }
}