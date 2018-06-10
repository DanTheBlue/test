package net.degogarty.test.services;


import net.degogarty.test.models.Apple;
import net.degogarty.test.models.Cart;
import net.degogarty.test.models.Item;
import net.degogarty.test.models.Orange;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

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
}
