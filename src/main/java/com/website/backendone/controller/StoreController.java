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
public class StoreController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/sections")
    public MappingJacksonValue getAllSections() {
        List<Section> sections = sectionService.getAllSections();
        return MappingJacksonValueBuilder.init(sections)
                .addFilter(Section.FILTER)
                .addFilter(Category.FILTER, "products")
                .build();
    }

    @GetMapping("/sections/{id}")
    public MappingJacksonValue getSection(@PathVariable Integer id) {
        Section section = sectionService.getSectionById(id);
        return MappingJacksonValueBuilder.init(section)
                .addFilter(Section.FILTER)
                .addFilter(Category.FILTER, "products")
                .build();
    }

    @GetMapping("/categories/{id}")
    public MappingJacksonValue getCategory(@PathVariable Integer id) {
        Category category = categoryService.getCategoryById(id);
        return MappingJacksonValueBuilder.init(category)
                .addFilter(Category.FILTER)
                .addFilter(Product.FILTER)
                .build();
    }

    @GetMapping("/products/{id}")
    public MappingJacksonValue getProduct(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return MappingJacksonValueBuilder.init(product)
                .addFilter(Product.FILTER)
                .build();
    }

    @PostMapping("/products")
    public MappingJacksonValue getProducts(@RequestBody List<Integer> ids) {
        List<Product> products = new ArrayList<>();
        for (Integer id : ids) {
            Product product = productService.getProductById(id);
            if (product != null) products.add(product);
        }
        return MappingJacksonValueBuilder.init(products)
                .addFilter(Product.FILTER,
                        "description",
                        "reviwCount",
                        "totalRating",
                        "category",
                        "reviews")
                .build();
    }
}