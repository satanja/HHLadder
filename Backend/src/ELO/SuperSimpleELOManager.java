package ELO;

import java.util.Comparator;

/**
 * @author S.A. Tanja
 * Switches the MMR of the loser and the winner if the loser was the lower ranked fencer.
 */
public class SuperSimpleELOManager extends ELOManager {

    @Override
    protected int calculateWinnerMMR(int winnerMMR, int loserMMR, int winnerBouts) {
        return Math.min(winnerMMR, loserMMR);
    }

    @Override
    protected int calculateLoserMMR(int winnerMMR, int loserMMR, int loserBouts) {
        return Math.max(winnerMMR, loserMMR);
    }

    @Override
    public int getInitialMMR(int position) {
        return position;
    }

    @Override
    public Comparator<ELOFencer> getComparator() {
        return ascendingMMR;
    }

    @Override
    public boolean isHiddenMMR() {
        return true;
    }
}
