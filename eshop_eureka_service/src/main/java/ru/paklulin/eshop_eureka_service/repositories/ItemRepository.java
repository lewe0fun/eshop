package ru.paklulin.eshop_eureka_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.paklulin.eshop_eureka_service.models.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
