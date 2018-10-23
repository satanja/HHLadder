package ELO;

import static org.junit.Assert.*;
import Records.Fencer;

import Records.Match;
import org.junit.Before;
import org.junit.Test;
import Weapon.*;



public class SimpleELOManagerTest extends ELOManagerTest {


    @Override
    public ELOManager setUpInstance() {
        return new SimpleELOManager();
    }

    @Test
    public void match1() {
        setUpMatch(14, 15);
        checkMMR(1400, 600);
    }


}