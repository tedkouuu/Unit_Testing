package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// USE ASSERT.assertEquals - GIVES MORE INFO WHEN THERE IS AN ERROR
// DON'T USE MAGIC NUMBERS, IT CAN LEAD TO WRONG BEHAVIOR
// USE DESCRIPTIVE NAMES FOR THE METHOD NAMES

public class AxeTest {

    public static final int ATTACK = 100;
    public static final int DURABILITY = 100;
    private static final int HEALTH = 100;
    private static final int EXP = 20;

    private Axe axe;
    private Dummy dummy;

    @Before // Before every test, I initialize new Axe and new Dummy
    public void setUp() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXP);
    }

    @Test
    public void testIfWeaponLosesDurabilityAfterEachAttack() {

        axe.attack(dummy);
        Assert.assertEquals(DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testIfExceptionIsThrownWhenAxeIsBroken() {

        Axe axe1 = new Axe(ATTACK, 0);

        axe1.attack(dummy);
    }
}