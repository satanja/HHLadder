/**
 * @author S.A. Tanja
 */
public interface ELOFencer {

    /**
     * Gets the number of bouts fenced
     * @return The number of bouts fenced
     */
    public int getBoutsFenced();

    /**
     * Increase the number of bouts fenced by one
     */
    public void increaseBoutsFenced();

    /**
     * Get the current MMR of the fencer
     * @return The MMR of the fencer
     */
    public int getMMR();

    /**
     * Set the MMR of the fencer to its new MMR
     * @param newMMR The new MMR of the fencer
     */
    public void setMMR(int newMMR);


}
