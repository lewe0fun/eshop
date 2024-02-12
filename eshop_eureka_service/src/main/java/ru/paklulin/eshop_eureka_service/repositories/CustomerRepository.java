package ru.paklulin.eshop_eureka_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.paklulin.eshop_eureka_service.models.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
