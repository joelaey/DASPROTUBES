package model;

public class Item {

    private String idItem;
    private String name;
    private String description;
    private int posX;
    private int posY;

    public String getIdItem() {
        return idItem;
    }

    public Item setIdItem(String idItem) {
        this.idItem = idItem;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public int[] getPosition() {
        return new int[] {posX, posY}; 
    }

    public Item setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        return this;
    }

}
