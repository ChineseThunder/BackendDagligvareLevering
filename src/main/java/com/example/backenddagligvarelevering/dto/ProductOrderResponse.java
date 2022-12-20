package com.example.backenddagligvarelevering.dto;

import com.example.backenddagligvarelevering.entity.ProductOrder;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor

public class ProductOrderResponse {

    private Long id;

    private int quantity;

    private int orders;

    public ProductOrderResponse(ProductOrder p) {
        this.id = p.getId();
        this.quantity = p.getQuantity();
        this.orders = p.getOrders();
    }
}
