package com.website.backendone.controller;

import com.website.backendone.constants.JacksonFilterConstants;
import com.website.backendone.entity.Category;
import com.website.backendone.entity.Product;
import com.website.backendone.entity.Review;
import com.website.backendone.entity.Section;
import com.website.backendone.service.CategoryService;
import com.website.backendone.service.ProductService;
import com.website.backendone.service.ReviewService;
import com.website.backendone.service.SectionService;
import com.website.backendone.utility.MappingJacksonValueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PostMapping("/reviews")
    public MappingJacksonValue addReview(@RequestBody Review review) {
//        System.out.println(review.getText());
//        System.out.println(review.getUserName());
//        System.out.println(review.getProduct().getProductId());
//        return null;
        reviewService.addReview(review);
        Product product = productService.getProduct(review.getProduct().getProductId());
        return MappingJacksonValueBuilder.init(product)
                .addFilter(JacksonFilterConstants.PRODUCT_FILTER)
                .build();

    }

    @DeleteMapping("/reviews")
    public MappingJacksonValue deleteReview(@RequestBody Review review) {
        reviewService.deleteReview(review.getReviewId());
        Product product = productService.getProduct(review.getProduct().getProductId());
        return MappingJacksonValueBuilder.init(product)
                .addFilter(JacksonFilterConstants.PRODUCT_FILTER)
                .build();
    }

}
