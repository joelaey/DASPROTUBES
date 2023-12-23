package model;

public class Mobs {

    private String name;
    private int health;
    private int attackPower;

    public Mobs() {
    }

    public String getName() {
        return name;
    }

    public Mobs setName(String name) {
        this.name = name;
        return this;
    }

    public int getHealth() {
        return health;
    }

    public Mobs setHealth(int health) {
        this.health = health;
        return this;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public Mobs setAttackPower(int attackPower) {
        this.attackPower = attackPower;
        return this;
    }
}
