package net.degogarty.test.models;

public enum ItemName {
    APPLE("apple"),
    ORANGE("orange"),
    BANANA("banana");

    private String value;

    ItemName(String value) {
        this.value = value;
    }

    public boolean equalValue(String name) {
        return this.value.equalsIgnoreCase(name);
    }
}
