package com.example.backenddagligvarelevering.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor

public class ProductOrderRequest {

    private Long id;

    private int quantity;

    private int orders;

}
