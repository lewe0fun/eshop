package ru.paklulin.eshop_eureka_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.paklulin.eshop_eureka_service.models.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}