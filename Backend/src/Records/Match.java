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

    public Match(ELOFencer fencerA, ELOFencer fencerB, int scoreA, int scoreB) {
        this.scoreA = scoreA;
        this.fencerA = fencerA;

        this.scoreB = scoreB;
        this.fencerB = fencerB;

        fencerA.increaseBoutsFenced();
        fencerB.increaseBoutsFenced();
    }

    /**
     * Gets the winner of the match
     * @return The fencer with the largest number of touches
     * @throws IllegalStateException If both fencers have the same number of touches
     */
    public ELOFencer getWinner() throws IllegalStateException {
        if (scoreA > scoreB) {
            return fencerA;
        } else if (scoreB > scoreA) {
            return  fencerB;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

    /**
     * Gets the loser of the match
     * @return The fencer with the least number of touches
     * @throws IllegalStateException If both fencers have the same number of touches
     */
    public ELOFencer getLoser() throws IllegalStateException {
        if (scoreA < scoreB) {
            return fencerA;
        } else if (scoreB < scoreA) {
            return fencerB;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

}
