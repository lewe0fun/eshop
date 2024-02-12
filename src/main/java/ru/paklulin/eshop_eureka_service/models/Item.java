package ru.paklulin.eshop_eureka_service.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 2, max = 50, message = "must be between 2 and 50")
    @Column(name = "item_name")
    private String name;
    @Column
    @NotEmpty(message = "name should not be empty")
    private double price;
    @Column
    private String description;
}