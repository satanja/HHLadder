package ELO;

public class SimpleELOManager extends ELOManager {

    @Override
    protected int calculateWinnerMMR(ELOFencer winner, ELOFencer loser) {
        return (loser.getMMR() + 400) / (winner.getBoutsFenced());
    }

    @Override
    protected int calculateLoserMMR(ELOFencer winner, ELOFencer loser) {
        return (winner.getMMR() - 400) / (loser.getBoutsFenced());
    }

    @Override
    public int getInitialMMR(int position) {
        return 1000;
    }
}
