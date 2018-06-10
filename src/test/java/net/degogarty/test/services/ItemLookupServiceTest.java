package net.degogarty.test.services;

import net.degogarty.test.models.Cart;
import net.degogarty.test.models.ItemLookup;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ItemLookupServiceTest {

    private ItemService itemService = new ItemService();

    @Test
    public void applyAppleDiscount() {
        List<ItemLookup> itemLookups = new ArrayList<>();
        itemLookups.add(new Apple());
        itemLookups.add(new Apple());
        itemLookups.add(new Apple());
        itemLookups.add(new Apple());
        Cart cart = new Cart(itemLookups);
        itemService.applyDiscounts(cart);
        assertThat(cart.getDiscount(), is(equalTo(120)));
    }


    @Test
    public void testLotsOfBananasDiscount() {
        List<ItemLookup> itemLookups = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            itemLookups.add(new Banana());
        }
        itemLookups.add(new Apple());
        itemLookups.add(new Apple());

        Cart cart = new Cart(itemLookups);

       itemService.applyDiscounts(cart);
        assertThat(cart.getDiscount(), is(equalTo(60)));
    }

}