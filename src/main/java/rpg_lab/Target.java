package rpg_lab;

// I SHOULD DEPEND ON ABSTRACTION, NOT ON DETAILS

public interface Target {

    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();
}
