package net.degogarty.test.models;

public class Receipt {

    private int totalCost;

    public Receipt (Cart cart) {
        int totalCost = 0;
        for (Item item: cart.getItems()) {
            totalCost = totalCost + item.getCost();
        }
        this.totalCost = totalCost;
    }

    public int getTotalCost() {
        return totalCost;
    }

}
