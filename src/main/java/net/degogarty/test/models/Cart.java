package net.degogarty.test.models;

import java.util.List;

public class Cart {

    private List<String> items;
    private int discount;

    public Cart(List<String> items) {
        this.items = items;
    }

    public void addToDiscount(int newDiscount) {
        this.discount = discount + newDiscount;
    }

    public int getDiscount() {
        return discount;
    }

    public List<String> getItems() {
        return items;
    }
}
