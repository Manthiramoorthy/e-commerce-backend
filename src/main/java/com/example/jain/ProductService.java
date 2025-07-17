package com.example.jain;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductDetails() {
        return productRepository.findAll();   
    } 
}
