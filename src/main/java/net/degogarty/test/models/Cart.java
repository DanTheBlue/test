package net.degogarty.test.models;

import java.util.List;

public class Cart {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Item item:
             items) {
            totalCost = totalCost + item.getCost();
        }
    }
}
