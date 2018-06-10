package net.degogarty.test.models;

public class Orange extends Item {

    private int cost = 25;
    private String name = "orange";

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }
}
