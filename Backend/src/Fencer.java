/**
 * @author S.A. Tanja
 *
 *
 */
public class Fencer implements ELOFencer, Comparable<Fencer> {

    // The name of the fencer
    private String name;

    // The weapon the fencer uses
    private Weapon weapon;

    // The match making rating (mmr) of the fencer
    private int mmr;

    // The number of bouts the fencer fenced
    private int boutsFenced;

    public Fencer(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
        boutsFenced = 0;
    }

    /**
     * Gets the name of the fencer
     * @return {@code this.name}
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the weapon of the fencer
     * @return {@code this.weapon}
     */
    public Weapon getWeapon() {
        return weapon;
    }


    @Override
    public int getBoutsFenced() {
        return boutsFenced;
    }


    @Override
    public void increaseBoutsFenced() {
        boutsFenced++;
    }

    @Override
    public int getMMR() {
        return 0;
    }

    @Override
    public void setMMR(int newMMR) {
        this.mmr = newMMR;
    }

    public static void main(String[] args) {

    }

    // To sort the ladder based on Fencer's MMR
    @Override
    public int compareTo(Fencer fencer) {
        return this.mmr - fencer.mmr;
    }
}
