/*
package com.example.backenddagligvarelevering.configuration;

import com.example.backenddagligvarelevering.entity.Delivery;
import com.example.backenddagligvarelevering.repository.DeliveryRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class DeliverySetup implements ApplicationRunner {

    DeliveryRepository deliveryRepository;

    public DeliverySetup(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void run (ApplicationArguments args) throws Exception {

        Delivery delivery1 = Delivery.builder()
                .id(1L)
                .deliveryDate(LocalDateTime.now())
                .fromWarehouse("København")
                .productOrder(null)
                .build();

        Delivery delivery2 = Delivery.builder()
                .id(2L)
                .deliveryDate(LocalDateTime.now())
                .fromWarehouse("Aarhus")
                .productOrder(null)
                .build();

        Delivery delivery3 = Delivery.builder()
                .id(3L)
                .deliveryDate(LocalDateTime.now())
                .fromWarehouse("Odense")
                .productOrder(null)
                .build();

        DeliveryRepository.save(delivery1);
        DeliveryRepository.save(delivery2);
        DeliveryRepository.save(delivery3);
    }
}

*/
