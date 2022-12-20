package com.example.backenddagligvarelevering.api;


import com.example.backenddagligvarelevering.dto.DeliveryRequest;
import com.example.backenddagligvarelevering.dto.DeliveryResponse;
import com.example.backenddagligvarelevering.service.DeliveryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DeliveryResponse addDelivery(@RequestBody DeliveryRequest body) {
        return deliveryService.addDelivery(body);
    }

    @GetMapping("/{id}")
    DeliveryResponse getDeliveryById(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id);
    }

    @GetMapping
    public List<DeliveryResponse> getDeliveries() {
        return deliveryService.getDeliveries();
    }
}
