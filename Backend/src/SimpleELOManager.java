public class SimpleELOManager extends ELOManager {

    @Override
    public void updateMMR(Match match) {
        ELOFencer winner = match.getWinner();
        ELOFencer loser = match.getLoser();
        winner.setMMR(calculateWinnerMMR(winner, loser));
        loser.setMMR(calculateLoserMMR(winner, loser));
    }

    @Override
    protected int calculateWinnerMMR(ELOFencer winner, ELOFencer loser) {
        return (loser.getMMR() + 400) / (winner.getBoutsFenced());
    }

    @Override
    protected int calculateLoserMMR(ELOFencer winner, ELOFencer loser) {
        return (winner.getMMR() - 400) / (loser.getBoutsFenced());
    }

}
