package net.degogarty.test.controllers;

import net.degogarty.test.models.Cart;
import net.degogarty.test.models.Receipt;
import net.degogarty.test.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/cart/")
@RestController
public class CartController {

    @Autowired
    private ItemService itemsService;

    @PostMapping
    public Receipt createCart(@RequestBody List<String> itemsList) {
        Cart cart = itemsService.convertToCart(itemsList);
        return new Receipt(cart);
    }
}
