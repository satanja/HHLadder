package Records;

import ELO.ELOFencer;

/**
 * @author S.A. Tanja
 */
public class Match {

    private ELOFencer winner;
    private ELOFencer loser;

    private int winnerTouches;
    private int loserTouches;

    public Match(ELOFencer fencerA, ELOFencer fencerB, int scoreA, int scoreB) {
        setWinnerByScore(fencerA, fencerB, scoreA, scoreB);
        setLoserByScore(fencerA, fencerB, scoreA, scoreB);
    }

    public Match(ELOFencer winner, ELOFencer loser) {
        this.winner = winner;
        this.loser = loser;
    }

    /**
     * Gets the winner of the match by the number of touches
     * @return The fencer with the largest number of touches
     * @throws IllegalStateException If both fencers have the same number of touches
     */
    private void setWinnerByScore(ELOFencer fencerA, ELOFencer fencerB, int scoreA, int scoreB) throws IllegalStateException {
        if (scoreA > scoreB) {
            winner = fencerA;
            winnerTouches = scoreA;
            return;
        } else if (scoreB > scoreA) {
            winner = fencerB;
            winnerTouches = scoreB;
            return;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

    /**
     * Gets the loser of the match by the number of touches
     * @return The fencer with the least number of touches
     * @throws IllegalStateException If both fencers have the same number of touches
     */
    private void setLoserByScore(ELOFencer fencerA, ELOFencer fencerB, int scoreA, int scoreB) throws IllegalStateException {
        if (scoreA < scoreB) {
            loser = fencerA;
            loserTouches = scoreA;
            return;
        } else if (scoreB < scoreA) {
            loser = fencerB;
            loserTouches = scoreB;
            return;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

    public ELOFencer getWinner() {
       return winner;
    }

    public ELOFencer getLoser() {
       return loser;
    }

}
