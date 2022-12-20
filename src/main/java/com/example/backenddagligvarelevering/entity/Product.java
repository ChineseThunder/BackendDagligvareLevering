package com.example.backenddagligvarelevering.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private int weight;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private List<ProductOrder> productOrder;

}
