public class Match {

    private Fencer fencerA;
    private int scoreA;

    private Fencer fencerB;
    private int scoreB;

    public Match(Fencer fencerA, Fencer fencerB, int scoreA, int scoreB) {
        this.scoreA = scoreA;
        this.fencerA = fencerA;

        this.scoreB = scoreB;
        this.fencerB = fencerB;
    }

    public Fencer getWinner() throws IllegalStateException {
        if (scoreA > scoreB) {
            return fencerA;
        } else if (scoreB > scoreA) {
            return  fencerB;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

    public Fencer getLoser() throws IllegalStateException {
        if (scoreA < scoreB) {
            return fencerA;
        } else if (scoreB < scoreA) {
            return fencerB;
        }
        throw new IllegalStateException("Fencers have same number of touches: " + scoreA + ", " + scoreB);
    }

}
