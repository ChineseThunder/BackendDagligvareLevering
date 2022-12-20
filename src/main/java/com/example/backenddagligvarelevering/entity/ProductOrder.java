package com.example.backenddagligvarelevering.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private int orders;


    @ManyToOne
    @JoinColumn(name = "order_data_id") // This is the name of the column in the database
    private Delivery delivery;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Product product;
}
