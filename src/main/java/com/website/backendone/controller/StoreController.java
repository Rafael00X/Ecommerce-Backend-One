package com.website.backendone.controller;

import com.website.backendone.constants.JacksonFilterConstants;
import com.website.backendone.entity.Category;
import com.website.backendone.entity.Product;
import com.website.backendone.entity.Section;
import com.website.backendone.service.CategoryService;
import com.website.backendone.service.ProductService;
import com.website.backendone.service.SectionService;
import com.website.backendone.utility.MappingJacksonValueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SectionService sectionService;

    @GetMapping("/sections")
    public MappingJacksonValue getAllSections() {
        List<Section> sections = sectionService.getAllSections();
        return MappingJacksonValueBuilder.init(sections)
                .addFilter(JacksonFilterConstants.SECTION_FILTER)
                .addFilter(JacksonFilterConstants.CATEGORY_FILTER, "products")
                .build();
    }

    @GetMapping("/sections/{id}")
    public MappingJacksonValue getSection(@PathVariable Integer id) {
        Section section = sectionService.getSection(id);
        return MappingJacksonValueBuilder.init(section)
                .addFilter(JacksonFilterConstants.SECTION_FILTER)
                .addFilter(JacksonFilterConstants.CATEGORY_FILTER, "products")
                .build();
    }

    @GetMapping("/categories/{id}")
    public MappingJacksonValue getCategory(@PathVariable Integer id) {
        Category category = categoryService.getCategory(id);
        return MappingJacksonValueBuilder.init(category)
                .addFilter(JacksonFilterConstants.CATEGORY_FILTER)
                .addFilter(JacksonFilterConstants.PRODUCT_FILTER)
                .build();
    }

    @GetMapping("/products/{id}")
    public MappingJacksonValue getProduct(@PathVariable Integer id) {
        Product product = productService.getProduct(id);
        return MappingJacksonValueBuilder.init(product)
                .addFilter(JacksonFilterConstants.PRODUCT_FILTER)
                .build();
    }

}
