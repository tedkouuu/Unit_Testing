package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest { // I USE DEPENDENCY INJECTION SO I CAN TEST THE CODE EASILY

    // EXAMPLE of stubbed implementation of Weapon just for tests

    private static class FakeWeapon implements Weapon {

        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {
        }
    }

    @Test
    public void testHeroGainsXPWhenTargetDies() {

        Hero hero = new Hero("Javarcho", new FakeWeapon());

        assertEquals(0, hero.getExperience());

        // Example of anonymous class instance of target just to fake methods
        Target target = new Target() { // Anonymous class
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 200; // THIS IS HARDCODED BECAUSE I WANT THIS METHOD TO ALWAYS RETURN 200
            }

            @Override
            public boolean isDead() {
                return true;  // THIS IS HARDCODED BECAUSE I WANT THIS METHOD TO ALWAYS RETURN true
            }
        };

        hero.attack(target);

        assertEquals(200, hero.getExperience());

    }

    @Test
    public void testHeroGainsXPWhenTargetDiesMocking() {

        Weapon weapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Javarcho", weapon);

        Assert.assertEquals(0, hero.getExperience());

        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true); // This is a setup of the method
        Mockito.when(target.giveExperience()).thenReturn(0);

        assertEquals(0, hero.getExperience());
    }
}



















