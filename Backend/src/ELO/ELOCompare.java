package ELO;

import Records.Fencer;
import java.util.Comparator;

/**
 * Class to sort fencers by MMR.
 */
public class ELOCompare implements Comparator<Fencer> {

    @Override
    public int compare(Fencer a, Fencer b) {
        return a.getMMR() - b.getMMR();
    }
}
