public interface MMRCreator {
    /**
     * Gets the initial MMR of the fencer (possibly taking its position in the ladder into account)
     * @param position
     * @return
     */
    public int getInitialMMR(int position);
}
