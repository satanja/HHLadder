/**
 * @author S.A. Tanja
 */
public abstract class ELOManager {

    /**
     * Updates the MMR of both fencers of the {@code match}
     * @param match The match played
     */
    public void updateMMR(Match match) {
        ELOFencer winner = match.getWinner();
        ELOFencer loser = match.getLoser();
        winner.setMMR(calculateWinnerMMR(winner, loser));
        loser.setMMR(calculateLoserMMR(winner, loser));
    }

    /**
     * Gets the initial MMR of the fencer (possibly taking its position in the ladder into account)
     * @param position The position of the fencer in the ladder directly after being added
     * @return The initial mmr of the fencer
     */
    public abstract int getInitialMMR(int position);


    /**
     * Calculates the new MMR of the winning fencer
     * @param winner The fencer who won the {@code match}
     * @param loser The fencer who lost the {@code match}
     * @return The new MMR of {@code winner}
     */
    protected abstract int calculateWinnerMMR(ELOFencer winner, ELOFencer loser);

    /**
     * Calculates the new MMR of the losing fencer
     * @param winner The fencer who won the {@code match}
     * @param loser The fencer who lost the {@code match}
     * @return The new MMR of {@code loser}
     */
    protected abstract int calculateLoserMMR(ELOFencer winner, ELOFencer loser);
}
