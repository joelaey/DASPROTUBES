package model;

public class Armor extends Item {
    private int healthBoost;

    public int getHealthBoost() {
        return healthBoost;
    }

    public Armor setHealthBoost(int healthBoost) {
        this.healthBoost = healthBoost;
        return this;
    }
}
