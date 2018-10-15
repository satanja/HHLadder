package Records;

import ELO.ELOFencer;

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
    }

    public ELOFencer getWinner() throws IllegalStateException {
        if (scoreA > scoreB) {
            return fencerA;
        } else if (scoreB > scoreA) {
            return  fencerB;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

    public ELOFencer getLoser() throws IllegalStateException {
        if (scoreA < scoreB) {
            return fencerA;
        } else if (scoreB < scoreA) {
            return fencerB;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

}
