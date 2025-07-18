package com.example.jain.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3020") // Adjust the origin as needed
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProductDetails();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    
    @PutMapping()
    public Product putMethodName(@RequestBody Product entity) {
        //TODO: process PUT request
        
        return productService.updateProduct(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable String id) {
        productService.deleteProduct(id);
    }
    
}
