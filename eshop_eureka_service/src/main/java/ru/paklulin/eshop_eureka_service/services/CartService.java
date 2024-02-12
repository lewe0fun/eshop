package ru.paklulin.eshop_eureka_service.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paklulin.eshop_eureka_service.models.Cart;
import ru.paklulin.eshop_eureka_service.models.Customer;
import ru.paklulin.eshop_eureka_service.models.Item;
import ru.paklulin.eshop_eureka_service.repositories.CartRepository;
import ru.paklulin.eshop_eureka_service.repositories.ItemRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    public List<Item> getCartItems(Customer customer) {
        return cartRepository.findByCustomer(customer);
    }
    @Transactional
    public int addItem(Long itemId, int quantity,Customer customer){
        int addedQuantity = quantity;
        Item item = itemRepository.findById(itemId).get();
        Cart cart = cartRepository.findByCustomerAndItem(customer,item);
        if (cart!=null){
            addedQuantity=cart.getQuantity()+quantity;
            cart.setQuantity(addedQuantity);
        } else{
            cart =new Cart();
            cart.setQuantity(quantity);
            cart.setItem(item);
            cart.setCustomer(customer);
        }
        cartRepository.save(cart);
        return  addedQuantity;
    }
    @Transactional
    public void deleteCart(Long id){
        cartRepository.deleteById(id);
    }
    @Transactional
    public void updateCart(int quantity,Customer customer,Item item){
        cartRepository.updateQuantity(quantity,customer,item);
    }
}
