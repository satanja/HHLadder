package Records;

import ELO.ELOFencer;

/**
 * @author S.A. Tanja
 */
public class Match {

    private ELOFencer fencerA;
    private int scoreA;

    private ELOFencer fencerB;
    private int scoreB;

    private boolean fencerADidWin;

    public Match(ELOFencer fencerA, ELOFencer fencerB, int scoreA, int scoreB) {
        this.scoreA = scoreA;
        this.fencerA = fencerA;

        this.scoreB = scoreB;
        this.fencerB = fencerB;

        fencerADidWin = getWinnerByScore() == fencerA;
    }

    public Match(ELOFencer fencerA, ELOFencer fencerB, boolean fencerADidWin) {
        this.fencerA = fencerA;
        this.fencerB = fencerB;
        this.fencerADidWin = fencerADidWin;
    }

    /**
     * Gets the winner of the match by the number of touches
     * @return The fencer with the largest number of touches
     * @throws IllegalStateException If both fencers have the same number of touches
     */
    private ELOFencer getWinnerByScore() throws IllegalStateException {
        if (scoreA > scoreB) {
            return fencerA;
        } else if (scoreB > scoreA) {
            return  fencerB;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

    /**
     * Gets the loser of the match by the number of touches
     * @return The fencer with the least number of touches
     * @throws IllegalStateException If both fencers have the same number of touches
     */
    private ELOFencer getLoserByScore() throws IllegalStateException {
        if (scoreA < scoreB) {
            return fencerA;
        } else if (scoreB < scoreA) {
            return fencerB;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

    public ELOFencer getWinner() {
        if (fencerADidWin) {
            return fencerA;
        }
        return fencerB;
    }

    public ELOFencer getLoser() {
        if (!fencerADidWin) {
            return fencerA;
        }
        return fencerB;
    }

}
