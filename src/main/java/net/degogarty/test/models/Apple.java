package net.degogarty.test.models;

public class Apple extends Item {

    private int cost = 25;
    private String name = "apple";

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }
}
