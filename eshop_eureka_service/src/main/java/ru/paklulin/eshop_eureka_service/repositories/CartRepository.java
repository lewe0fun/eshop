package ru.paklulin.eshop_eureka_service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.paklulin.eshop_eureka_service.models.Cart;
import ru.paklulin.eshop_eureka_service.models.Customer;
import ru.paklulin.eshop_eureka_service.models.Item;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{
    List<Item> findByCustomer(Customer customer);
    void deleteByCustomerAndItem(Customer customer,Item item);
    void updateQuantity(int quantity,Customer customer,Item item);

    Cart findByCustomerAndItem(Customer customer, Item item);
}