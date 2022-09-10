package rpg_lab;

// I SHOULD DEPEND ON ABSTRACTION, NOT ON DETAILS

public interface Weapon {
    int getAttackPoints();

    int getDurabilityPoints();

    void attack(Target target);
}
