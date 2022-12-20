package com.example.backenddagligvarelevering.api;


import com.example.backenddagligvarelevering.dto.ProductOrderRequest;
import com.example.backenddagligvarelevering.dto.ProductOrderResponse;
import com.example.backenddagligvarelevering.service.ProductOrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/productorder")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProductOrderResponse addProductOrder(@RequestBody ProductOrderRequest body){
        return productOrderService.addProductOrder(body);
    }

    @PostMapping("{id}")
    ProductOrderResponse getProductOrderById(Long id){
        return productOrderService.getProductOrderById(id);
    }
    @GetMapping
    public List<ProductOrderResponse> getProductOrders(){
        return productOrderService.getProductOrders();
    }
}
