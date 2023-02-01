package com.website.backendone.service;

import com.website.backendone.entity.Category;
import com.website.backendone.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category getCategoryById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
