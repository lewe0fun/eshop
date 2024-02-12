package ru.paklulin.eshop_eureka_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private int rating;
    @Column
    private String description;
    @OneToOne()
    @JoinColumn(name = "item_id")
    private Item item;
}