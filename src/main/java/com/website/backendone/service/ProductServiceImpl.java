package com.website.backendone.service;

import com.website.backendone.entity.Product;
import com.website.backendone.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    public Product getProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
