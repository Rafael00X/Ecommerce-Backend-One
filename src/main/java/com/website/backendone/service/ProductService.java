package com.website.backendone.service;

import com.website.backendone.entity.Product;
import com.website.backendone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product getProduct(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
