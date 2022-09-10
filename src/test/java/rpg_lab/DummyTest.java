package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// USE ASSERT.assertEquals - GIVES MORE INFO WHEN THERE IS AN ERROR
// DON'T USE MAGIC NUMBERS, IT CAN LEAD TO WRONG BEHAVIOR

public class DummyTest {

    public static final int DEAD_DUMMY_HEALTH = -100;
    public static final int DEAD_DUMMY_EXP = 100;
    public static final int ALIVE_DUMMY_HEALTH = 50;
    public static final int ALIVE_DUMMY_EXP = 50;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {

        this.aliveDummy = new Dummy(ALIVE_DUMMY_HEALTH, ALIVE_DUMMY_EXP);
        this.deadDummy = new Dummy(DEAD_DUMMY_HEALTH, DEAD_DUMMY_EXP);

    }

    @Test
    public void testIfDummyLosesHealthWhenAttacked() {

        aliveDummy.takeAttack(10);

        Assert.assertEquals(40, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testIfDeadDummyThrowsExceptionWhenAttacked() {

        deadDummy.takeAttack(10);
    }

    @Test
    public void testIfDeadDummyGivesXP() {

        deadDummy.giveExperience();

        Assert.assertEquals(100, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testIfAliveDummyThrows() {

        aliveDummy.giveExperience();
    }
}