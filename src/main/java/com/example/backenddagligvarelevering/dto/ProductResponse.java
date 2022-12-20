package com.example.backenddagligvarelevering.dto;

import com.example.backenddagligvarelevering.entity.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor

public class ProductResponse {

    private Long id;

    private String name;

    private int price;

    private int weight;

    public ProductResponse(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.price = p.getPrice();
        this.weight = p.getWeight();
    }
}
