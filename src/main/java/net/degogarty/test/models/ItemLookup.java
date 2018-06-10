package net.degogarty.test.models;

public class ItemLookup {

    private ItemName name;
    private int cost;
    private int discountLimit;

    public static final int BOGOF_DISCOUNT_LIMIT = 2;
    public static final int THREE_FOR_TWO_LIMIT = 3;

    //Data structures
    private static final ItemLookup apple = new ItemLookup(ItemName.APPLE, 60, BOGOF_DISCOUNT_LIMIT);
    private static final ItemLookup orange = new ItemLookup(ItemName.ORANGE, 25, THREE_FOR_TWO_LIMIT);
    private static final ItemLookup banana = new ItemLookup(ItemName.BANANA, 20, BOGOF_DISCOUNT_LIMIT);

    private ItemLookup(ItemName name, int cost, int discountLimit) {
        this.name = name;
        this.cost = cost;
        this.discountLimit = discountLimit;
    }

    public static int getCost(ItemName name) {
        return getItemFromItemName(name).cost;
    }

    public static int getCost(String name) {

        return getItemFromItemName(ItemName.valueOf(name)).cost;
    }

    public static int getDiscountLimit(ItemName name) {
        return getItemFromItemName(name).discountLimit;
    }

    public static ItemLookup findItemByName(String name) {
        return getItemFromItemName(ItemName.valueOf(name));
    }

    private static ItemLookup getItemFromItemName(ItemName name) {
        switch (name) {
            case APPLE:
                return apple;
            case BANANA:
                return banana;
            case ORANGE:
                return orange;
            default:
                return null;
        }
    }


}
