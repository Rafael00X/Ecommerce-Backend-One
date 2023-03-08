package com.website.backendone.controller;

import com.website.backendone.entity.Category;
import com.website.backendone.entity.Product;
import com.website.backendone.entity.Section;
import com.website.backendone.service.*;
import com.website.backendone.utility.MappingJacksonValueBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories/{id}")
    public MappingJacksonValue getCategory(@PathVariable Integer id) {
        Category category = categoryService.getCategoryById(id);
        return MappingJacksonValueBuilder.init(category)
                .addFilter(Category.FILTER)
                .addFilter(Product.FILTER)
                .build();
    }
}