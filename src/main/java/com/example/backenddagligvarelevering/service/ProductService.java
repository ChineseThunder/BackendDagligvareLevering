package com.example.backenddagligvarelevering.service;


import com.example.backenddagligvarelevering.dto.ProductRequest;
import com.example.backenddagligvarelevering.dto.ProductResponse;
import com.example.backenddagligvarelevering.entity.Product;
import com.example.backenddagligvarelevering.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product newProduct = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .weight(productRequest.getWeight())
                .build();

        productRepository.save(newProduct);
        return new ProductResponse(newProduct);
    }

    public List<ProductResponse> getProducts() {
        List<Product> product = productRepository.findAll();
        return product.stream().map(o -> new ProductResponse(o)).collect(Collectors.toList());
    }

    public ProductResponse getProductById(@PathVariable Long id) {
        return new ProductResponse(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found")));
    }

    public void editProduct(ProductRequest productRequest, Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with this ID does not exist"));
        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setWeight(productRequest.getWeight());
        productRepository.save(product);
    }

    public void deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with this ID does not exist"));
        productRepository.delete(product);
    }

    public List<ProductResponse> findByName(String name) {
        List<Product> products = productRepository.findByName(name);
        return products.stream().map(o -> new ProductResponse(o)).collect(Collectors.toList());
    }
}
