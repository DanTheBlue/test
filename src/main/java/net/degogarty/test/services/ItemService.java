package net.degogarty.test.services;


import net.degogarty.test.models.*;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class ItemService {


    public void applyDiscounts(Cart cart) {
        applyBogofDiscount(cart);
        applyOrangeDiscount(cart);
    }

    /**
     * Applies the bogof discount, which applies to both bananas and apples
     * @param cart to check and apply the discount if needed
     */
    private void applyBogofDiscount(Cart cart) {
        int bananaAmount = countItemsWithName(cart, ItemName.BANANA);
        int appleAmount = countItemsWithName(cart, ItemName.APPLE);

        int totalDiscount = (bananaAmount + appleAmount) / ItemLookup.BOGOF_DISCOUNT_LIMIT;

        for (int i = 0; i < totalDiscount; i++) {
            if(bananaAmount > i) {
                cart.addToDiscount(ItemLookup.getDiscountLimit(ItemName.BANANA));
            } else {
                cart.addToDiscount(ItemLookup.getDiscountLimit(ItemName.APPLE));
            }
        }
    }
    
    private void applyOrangeDiscount(Cart cart) {
        int orangeDiscountAmount = countItemsWithName(cart, ItemName.ORANGE) / ItemLookup.getDiscountLimit(ItemName.ORANGE);
        cart.addToDiscount(ItemLookup.getCost(ItemName.ORANGE) * orangeDiscountAmount);
    }

    private int countItemsWithName(Cart cart, ItemName name) {
        return Collections.frequency(cart.getItems(), name.toString());
    }
}
