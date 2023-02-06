package com.website.backendone.service;

import com.website.backendone.entity.Product;

public interface ProductService {
    Product getProductById(Integer id);
    Product updateProduct(Product product);
}
