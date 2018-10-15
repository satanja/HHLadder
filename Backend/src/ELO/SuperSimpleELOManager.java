package ELO;

/**
 * @author S.A. Tanja
 * Switches the MMR of the loser and the winner if the loser was the lower ranked fencer.
 */
public class SuperSimpleELOManager extends ELOManager {

    @Override
    protected int calculateWinnerMMR(ELOFencer winner, ELOFencer loser) {
        return Math.max(winner.getMMR(), loser.getMMR());
    }

    @Override
    protected int calculateLoserMMR(ELOFencer winner, ELOFencer loser) {
        return Math.min(winner.getMMR(), loser.getMMR());
    }

    @Override
    public int getInitialMMR(int position) {
        return position;
    }
}
