package com.website.backendone.service;

import com.website.backendone.entity.Category;
import com.website.backendone.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category getCategory(Integer id) {
        return repository.findById(id).orElse(null);
    }
}