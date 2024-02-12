package ru.paklulin.eshop_eureka_service.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 2, max = 32, message = "too long name")
    @Column(name = "person_name")
    private String name;
    @NotEmpty(message = "pass should not be empty")
    String password;
    @NotEmpty(message = "name should not be empty")
    @Email(message = "email isn't valid")
    @Column(name = "email")
    String email;
}
