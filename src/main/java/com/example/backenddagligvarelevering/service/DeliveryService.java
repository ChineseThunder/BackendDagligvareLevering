package com.example.backenddagligvarelevering.service;


import com.example.backenddagligvarelevering.dto.DeliveryRequest;
import com.example.backenddagligvarelevering.dto.DeliveryResponse;
import com.example.backenddagligvarelevering.entity.Delivery;
import com.example.backenddagligvarelevering.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryService (DeliveryRepository deliveryRepository){
        this.deliveryRepository = deliveryRepository;
    }

    public DeliveryResponse addDelivery(DeliveryRequest deliveryRequest){
       /* if(deliveryRepository.existsById(deliveryRequest.getId())){
            throw new RuntimeException("Delivery with this id already axist");
        }*/
        Delivery newDelivery = Delivery.builder()
                .deliveryDate(deliveryRequest.getDeliveryDate())
                .fromWarehouse(deliveryRequest.getFromWarehouse())
                .destination(deliveryRequest.getDestination())
                .build();

        deliveryRepository.save(newDelivery);
        return new DeliveryResponse(newDelivery);
    }

    public List<DeliveryResponse> getDeliveries(){
        List<Delivery> delivery = deliveryRepository.findAll();
        return delivery.stream().map(o->new DeliveryResponse(o)).collect(Collectors.toList());
    }

    public DeliveryResponse getDeliveryById(@PathVariable Long id){
        return new DeliveryResponse(deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Delivery not found")));
    }
}
