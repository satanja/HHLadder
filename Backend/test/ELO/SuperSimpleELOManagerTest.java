package ELO;

import Records.Fencer;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuperSimpleELOManagerTest extends ELOManagerTest {


    private int count;

    @Override
    public ELOManager setUpInstance() {
        return new SuperSimpleELOManager();
    }


    @Override
    protected void initializeMMR(Fencer fencer) {
        count++;
        fencer.setMMR(instance.getInitialMMR(count));
    }

    @Test
    public void match1() {
        setUpMatch(10, 5);
        checkMMR(1, 2);
    }

    @Test
    public void match2() {
        setUpMatch(5, 10);
        checkMMR(1, 2);
    }


}