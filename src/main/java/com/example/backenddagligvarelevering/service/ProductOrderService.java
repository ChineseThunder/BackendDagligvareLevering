package com.example.backenddagligvarelevering.service;


import com.example.backenddagligvarelevering.dto.ProductOrderRequest;
import com.example.backenddagligvarelevering.dto.ProductOrderResponse;
import com.example.backenddagligvarelevering.entity.ProductOrder;
import com.example.backenddagligvarelevering.repository.ProductOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    private final ProductOrderRepository productOrderRepository;

    public ProductOrderService(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    public ProductOrderResponse addProductOrder(ProductOrderRequest productOrderRequest) {
        if(productOrderRepository.existsById(productOrderRequest.getId())) {
            throw new IllegalArgumentException("Product order already exists");
        }
        ProductOrder newProductOrder = ProductOrder.builder()
                .id(productOrderRequest.getId())
                .quantity(productOrderRequest.getQuantity())
                .orders(productOrderRequest.getOrders())
                .build();

        productOrderRepository.save(newProductOrder);
        return new ProductOrderResponse(newProductOrder);
    }

    public List<ProductOrderResponse> getProductOrders() {
        List<ProductOrder> productOrder = productOrderRepository.findAll();
        return productOrder.stream().map(o -> new ProductOrderResponse(o)).collect(Collectors.toList());
    }

    public ProductOrderResponse getProductOrderById(Long id) {
        return new ProductOrderResponse(productOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Product order order not found")));
    }
}
