package com.example.backenddagligvarelevering.configuration;
import com.example.backenddagligvarelevering.entity.Product;
import com.example.backenddagligvarelevering.repository.ProductRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class ProductSetup implements ApplicationRunner {

    ProductRepository productRepository;

    public ProductSetup(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run (ApplicationArguments args) throws Exception {

        Product product1 = Product.builder()
                .id(1L)
                .name("mælk")
                .price(17)
                .weight(1000)
                .productOrder(null)
                .build();

        Product product2 = Product.builder()
                .id(2L)
                .name("kaffe")
                .price(10)
                .weight(1000)
                .productOrder(null)
                .build();

        Product product3 = Product.builder()
                .id(3L)
                .name("Ost")
                .price(10)
                .weight(1000)
                .productOrder(null)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
    }
}
