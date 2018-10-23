package ELO;


import static org.junit.Assert.*;
import Records.*;
import Weapon.*;
import org.junit.Before;

import java.util.Random;

public abstract class ELOManagerTest {

    // The ELOManager to test
    private ELOManager instance;

    // A test match to test with
    private Match testMatch;

    // Both fencers present in the testMatch
    private Fencer a;
    private Fencer b;

    // Random for position generation
    private Random randomPosition = new Random();

    // Subclass is responsible for instance initialization

    public ELOManagerTest() {
        instance = setUpInstance();
    }

    public abstract ELOManager setUpInstance();

    @Before
    public void setUpFencers() {
        Weapon epee = new Epee();
        a = new Fencer("a", epee);
        b = new Fencer("b", epee);
        intializeMMR(a);
        intializeMMR(b);
    }

    /**
     * Intializes a new match between fencers a and b and updates the MMR of both fencers
     * @param scoreA The number of touches of fencer a
     * @param scoreB The number of touches of fencer b
     */
    protected void setUpMatch(int scoreA, int scoreB) {
        testMatch = new Match(a, b, scoreA, scoreB);
        instance.updateMMR(testMatch);
    }

    /**
     * Intialize the mmr of the fencers
     * @param fencer
     */
    protected void intializeMMR(Fencer fencer) {
        int position = randomPosition.nextInt(100) + 1;
        fencer.setMMR(instance.getInitialMMR(position));
    }

    /**
     * Check whether the fencers have the expected MMR
     * @param expectedWinnerMMR The expected MMR of the winner
     * @param expectedLoserMMR The expected MMR of the loser
     */
    public void checkMMR(int expectedWinnerMMR, int expectedLoserMMR) {
        checkWinnerMMR(expectedWinnerMMR);
        checkLoserMMR(expectedLoserMMR);
    }

    /**
     * Check whether the winning fencer has the correct MMR
     * @param expectedMMR The expected MMR of the winner
     */
    private void checkWinnerMMR(int expectedMMR) {
        assertEquals(expectedMMR, testMatch.getWinner().getMMR());
    }

    /**
     * Check whether the losing fencer has the correct MMR
     * @param expectedMMR The expected MMR of the loser
     */
    private void checkLoserMMR(int expectedMMR) {
        assertEquals(expectedMMR, testMatch.getLoser().getMMR());
    }

}