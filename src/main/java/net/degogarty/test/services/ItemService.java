package net.degogarty.test.services;


import net.degogarty.test.models.Apple;
import net.degogarty.test.models.Cart;
import net.degogarty.test.models.Item;
import net.degogarty.test.models.Orange;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ItemService {

    private final int appleCount = 3;
    private final int appleDiscount = 60;

    private final int orangeCount = 3;
    private final int orangeDiscount = 25;

    public Cart convertToCart(List<String> items) {
        List<Item> stringItems = new ArrayList<>();
        for (String item: items) {
            switch(item) {
                case "apple": stringItems.add(new Apple());
                    break;
                case "orange" : stringItems.add(new Orange());
                    break;
            }
        }
        return new Cart(stringItems);
    }

    public void applyAppleDiscount(Cart cart) {
        int appleDiscountAmount = countItemsWithName(cart, "apple") / appleCount;
        cart.addToDiscount(appleDiscount * appleDiscountAmount);
    }
    
    public void applyOrangeDiscount(Cart cart) {
        int orangeDiscountAmount = countItemsWithName(cart, "orange") / orangeCount;
        cart.addToDiscount(orangeDiscount * orangeDiscountAmount);
    }

    public int countItemsWithName(Cart cart, String name) {
        int finalCount = 0;
        for (Item item: cart.getItems()) {
            if(item.getName().equalsIgnoreCase(name)) {
                finalCount++;
            }
        }
        return finalCount;
    }
}
