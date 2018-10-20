package ELO;

/**
 * @author S.A. Tanja
 * Switches the MMR of the loser and the winner if the loser was the lower ranked fencer.
 */
public class SuperSimpleELOManager extends ELOManager {

    @Override
    protected int calculateWinnerMMR(int winnerMMR, int loserMMR, int winnerBouts) {
        return Math.max(winnerMMR, loserMMR);
    }

    @Override
    protected int calculateLoserMMR(int winnerMMR, int loserMMR, int loserBouts) {
        return Math.min(winnerMMR, loserMMR);
    }

    @Override
    public int getInitialMMR(int position) {
        return position;
    }
}
