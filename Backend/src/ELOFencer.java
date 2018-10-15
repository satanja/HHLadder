/**
 * @author S.A. Tanja
 */
public interface ELOFencer {

    /**
     * Gets the number of bouts fenced
     * @return The number of bouts fenced
     */
    int getBoutsFenced();

    /**
     * Increase the number of bouts fenced by one
     */
    void increaseBoutsFenced();

    /**
     * Get the current MMR of the fencer
     * @return The MMR of the fencer
     */
    int getMMR();

    /**
     * Set the MMR of the fencer to its new MMR
     * @param newMMR The new MMR of the fencer
     */
    void setMMR(int newMMR);


}
