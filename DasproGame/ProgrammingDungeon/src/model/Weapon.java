package model;

public class Weapon extends Item {
    private int attackBoost;

    public int getAttackBoost() {
        return attackBoost;
    }

    public Weapon setAttackBoost(int attackBoost) {
        this.attackBoost = attackBoost;
        return this;
    }
}
