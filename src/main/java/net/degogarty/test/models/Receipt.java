package net.degogarty.test.models;

public class Receipt {

    private int totalCost;

    public Receipt (Cart cart) {
        int totalCost = 0;
        for (String item : cart.getItems()) {
            totalCost = totalCost + itemLookup.getCost();
            totalCost = totalCost + ItemLookup.getCost(item);
        }
        this.totalCost = totalCost - cart.getDiscount();
    }

    public int getTotalCost() {
        return totalCost;
    }

}
