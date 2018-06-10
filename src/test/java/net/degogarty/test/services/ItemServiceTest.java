package net.degogarty.test.services;

import net.degogarty.test.models.Apple;
import net.degogarty.test.models.Cart;
import net.degogarty.test.models.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ItemServiceTest {

    private ItemService itemService = new ItemService();

    @Test
    public void applyAppleDiscount() {
        List<Item> items = new ArrayList<>();
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        Cart cart = new Cart(items);
        assertThat(cart.getDiscount(), is(equalTo(60)));
    }

    @Test
    public void testCountItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        Cart cart = new Cart(items);
        assertThat(itemService.countItemsWithName(cart, "apple"), is(equalTo(4)));
    }

}