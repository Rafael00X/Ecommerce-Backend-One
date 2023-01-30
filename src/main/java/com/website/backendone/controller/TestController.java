package com.website.backendone.controller;

import com.website.backendone.entity.Product;
import com.website.backendone.service.ProductService;
import com.website.backendone.utility.MappingJacksonValueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private ProductService productService;
    @PostMapping("/test/products")
    public MappingJacksonValue getProducts(@RequestBody List<Integer> ids) {
        System.out.println(ids);
        List<Product> products = new ArrayList<>();
        for (Integer id: ids) {
            Product product = productService.getProduct(id);
            if (product != null) products.add(product);
        }
        return MappingJacksonValueBuilder.init(products)
                .addFilter(Product.FILTER,
                        "description",
                        "markedPrice",
                        "reviwCount",
                        "totalRating",
                        "category",
                        "reviews")
                .build();
    }
}
