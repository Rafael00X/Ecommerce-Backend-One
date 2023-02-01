package com.website.backendone.service;

import com.website.backendone.entity.Product;
import com.website.backendone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public Product getProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
