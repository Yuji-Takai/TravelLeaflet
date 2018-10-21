package edu.gatech.travelleaflet.Models;
public class Item {
    private int type;
    private String name;
    private int quantity;
    private boolean isChecked;

    public Item() { }

    public Item(int type, String name, int quantity) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        isChecked = false;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isChecked() {
        return isChecked;
    }
}