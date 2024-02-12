package ru.paklulin.eshop_eureka_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.paklulin.eshop_eureka_service.models.Customer;
import ru.paklulin.eshop_eureka_service.models.Item;
import ru.paklulin.eshop_eureka_service.services.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart/")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public List<Item> getItemsOfCustomer(@RequestBody Customer customer) {
        return cartService.getCartItems(customer);
    }

    @PostMapping("/add/{id}/{quantity}")
    public int addItem(@PathVariable("id") long id,
                       @PathVariable("quantity") int quantity,
                       @RequestBody Customer customer) {
        return cartService.addItem(id, quantity, customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable("id") long id) {
        cartService.deleteCart(id);
    }
}
