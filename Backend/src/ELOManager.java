/**
 * @author S.A. Tanja
 */
public abstract class ELOManager implements MMRCreator {

    /**
     * Updates the MMR of both fencers of the {@code match}
     * @param match
     */
    public abstract void updateMMR(Match match);


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
