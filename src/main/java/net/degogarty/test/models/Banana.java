package net.degogarty.test.models;

public class Banana extends Item {

    private int cost = 20;
    private String name = "banana";
    @Override
    public int getCost() {
        return 20;
    }

    @Override
    public String getName() {
        return null;
    }
}
