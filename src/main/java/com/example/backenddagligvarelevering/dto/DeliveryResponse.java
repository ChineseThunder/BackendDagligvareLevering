package com.example.backenddagligvarelevering.dto;

import com.example.backenddagligvarelevering.entity.Delivery;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor

public class DeliveryResponse {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",shape = JsonFormat.Shape.STRING)
    private LocalDateTime deliveryDate;

    private String fromWarehouse;

    private String destination;

    public DeliveryResponse(Delivery d) {
        this.id = d.getId();
        this.deliveryDate = d.getDeliveryDate();
        this.fromWarehouse = d.getFromWarehouse();
        this.destination = d.getDestination();
    }
}
