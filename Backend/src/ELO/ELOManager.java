package ELO;
import Records.Match;

import java.util.Comparator;

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

        int winnerMMR = winner.getMMR();
        int winnerBouts = winner.getBoutsFenced();

        int loserMMR = loser.getMMR();
        int loserBouts = loser.getBoutsFenced();

        winner.setMMR(calculateWinnerMMR(winnerMMR, loserMMR, winnerBouts));
        loser.setMMR(calculateLoserMMR(winnerMMR, loserMMR, loserBouts));
    }

    /**
     * Gets the initial MMR of the fencer (possibly taking its position in the ladder into account)
     * @param position The position of the fencer in the ladder directly after being added
     * @return The initial mmr of the fencer
     */
    public abstract int getInitialMMR(int position);


    /**
     * Calculates the new MMR of the winning fencer
     * @param winnerMMR The MMR of the winner before the match
     * @param loserMMR The MMR of the loser before the match
     * @param winnerBouts The number of bouts the winner played
     * @return The new MMR of {@code winner}
     */
    protected abstract int calculateWinnerMMR(int winnerMMR, int loserMMR, int winnerBouts);

    /**
     * Calculates the new MMR of the losing fencer
     * @param winnerMMR The MMR of the winner before the match
     * @param loserMMR The MMR of the loser before the match
     * @param loserBouts The number of bouts the loser played
     * @return The new MMR of {@code loser}
     */
    protected abstract int calculateLoserMMR(int winnerMMR, int loserMMR, int loserBouts);

    /**
     * Comparator to sort fencers in ascending order
     */
    protected static Comparator<ELOFencer> ascendingMMR = (a, b) -> a.getMMR() - b.getMMR();

    /**
     * Comparator to sort fencers in descending order
     */
    protected static Comparator<ELOFencer> descendingMMR = (a, b) -> b.getMMR() - a.getMMR();

    /**
     * Gets the correct comparator of the ELOManager
     * @return
     */
    public abstract Comparator<ELOFencer> getComparator();
}
