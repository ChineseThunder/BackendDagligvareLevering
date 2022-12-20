package com.example.backenddagligvarelevering.api;

import com.example.backenddagligvarelevering.dto.ProductRequest;
import com.example.backenddagligvarelevering.dto.ProductResponse;
import com.example.backenddagligvarelevering.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProductResponse addProduct(@RequestBody ProductRequest body) {
        return productService.addProduct(body);
    }

    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @PutMapping("/{id}")
    ResponseEntity<Boolean> editProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id){
        productService.editProduct(productRequest, id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProductResponse>> findProductByName(@RequestParam String name) {
        List<ProductResponse> products = productService.findByName(name);
        return ResponseEntity.ok(products);
    }
}

