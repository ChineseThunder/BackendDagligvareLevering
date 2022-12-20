package com.example.backenddagligvarelevering.service;

import com.example.backenddagligvarelevering.dto.ProductRequest;
import com.example.backenddagligvarelevering.dto.ProductResponse;
import com.example.backenddagligvarelevering.entity.Product;
import com.example.backenddagligvarelevering.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductServiceTest {
    public static ProductService productService;
    public static ProductRepository productRepository;

    @BeforeAll
    public static void initData(@Autowired ProductRepository product_Repository){
        productRepository = product_Repository;
        productRepository.deleteAll();

        Product product1 = Product.builder()
                .id(1L)
                .name("mælk")
                .price(17)
                .weight(1000)
                .productOrder(null)
                .build();

        Product product2 = Product.builder()
                .id(2L)
                .name("oksekød")
                .price(35)
                .weight(400)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
    }

    @BeforeEach
    public void setProductServiceUp(){
        productService = new ProductService(productRepository);
    }

    @Test
    void addProduct() {
        List<ProductResponse> products = productService.getProducts();
        assertEquals(2,products.size());

        Product product3 = Product.builder()
                .id(3L)
                .name("kattemad")
                .price(20)
                .weight(200)
                .build();

        ProductRequest productRequest = new ProductRequest(product3);
        productService.addProduct(productRequest);

        List<ProductResponse>updatedListOfproducts = productService.getProducts();

        assertEquals(3,updatedListOfproducts.size());

        assertEquals(3L,updatedListOfproducts.get(2).getId());
        assertEquals("kattemad",updatedListOfproducts.get(2).getName());
        assertEquals(20,updatedListOfproducts.get(2).getPrice());
    }

    @Test
    void getProduct() {
        List<ProductResponse> products = productService.getProducts();

        assertEquals(2, products.size());
        assertEquals(1L, products.get(0).getId());

        assertNotEquals(3, products.size());
        assertNotEquals("kattemad", products.get(0).getName());
        assertNotSame(products.get(0), products.get(1));
    }

    @Test
    void editProduct() {
        List<ProductResponse> products = productService.getProducts();
        assertEquals(2,products.size());

        Product product3 = Product.builder()
                .id(3L)
                .name("kattemad")
                .price(20)
                .weight(200)
                .build();

        ProductRequest productRequest = new ProductRequest(product3);
        productService.addProduct(productRequest);

        List<ProductResponse>updatedListOfproducts = productService.getProducts();

        assertEquals(3,updatedListOfproducts.size());

        assertEquals(3L,updatedListOfproducts.get(2).getId());
        assertEquals("kattemad",updatedListOfproducts.get(2).getName());
        assertEquals(20,updatedListOfproducts.get(2).getPrice());
    }

    @Test
    void deleteProduct() {
        List<ProductResponse> products = productService.getProducts();
        assertEquals(2,products.size());
        assertEquals( "mælk", products.get(0).getName());

        productService.deleteProduct(1L);
        List<ProductResponse>updatedListOfproducts = productService.getProducts();
        assertEquals(1,updatedListOfproducts.size());
        assertEquals( "oksekød", updatedListOfproducts.get(0).getName());
        assertEquals(35,updatedListOfproducts.get(0).getPrice());
    }
}