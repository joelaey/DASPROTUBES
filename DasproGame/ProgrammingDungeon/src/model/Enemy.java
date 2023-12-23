package model;

public class Enemy extends Mobs {

    private String idEnemy;
    private int buffHealth;
    private int buffAttackPower;
    private int posX;
    private int posY;

    public String getIdEnemy() {
        return idEnemy;
    }

    public Enemy setIdEnemy(String idEnemy) {
        this.idEnemy = idEnemy;
        return this;
    }

    public int getBuffHealth() {
        return buffHealth;
    }

    public Enemy setBuffHealth(int buffHealth) {
        this.buffHealth = buffHealth;
        return this;
    }

    public int getBuffAttackPower() {
        return buffAttackPower;
    }

    public Enemy setBuffAttackPower(int buffAttackPower) {
        this.buffAttackPower = buffAttackPower;
        return this;
    }
    
    public int[] getPosition() {
        return new int[] {posX, posY}; 
    }

    public Enemy setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        return this;
    }

}
