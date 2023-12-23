package model;

import java.util.ArrayList;

public class Player extends Mobs {

    private String idPlayer;
    private ArrayList<Item> inventory;
    private Armor equippedArmor;
    private Weapon equippedWeapon;

    public String getIdPlayer() {
        return idPlayer;
    }

    public Player setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
        return this;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Player setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
        return this;
    }

    public void addItem (Item item){
        inventory.add(item);
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public Player setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
        return this;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public Player setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
        return this;
    }
}
