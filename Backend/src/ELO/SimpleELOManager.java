package ELO;

/**
 * @author S.A. Tanja
 */
public class SimpleELOManager extends ELOManager {

    @Override
    protected int calculateWinnerMMR(int winnerMMR, int loserMMR, int winnerBouts) {
        return (loserMMR + 400) / (winnerBouts);
    }

    @Override
    protected int calculateLoserMMR(int winnerMMR, int loserMMR, int loserBouts) {
        return (winnerMMR - 400) / (loserBouts);
    }

    @Override
    public int getInitialMMR(int position) {
        return 1000;
    }
}
