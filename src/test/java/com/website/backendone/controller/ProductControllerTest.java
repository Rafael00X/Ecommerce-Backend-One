package com.website.backendone.controller;

import com.website.backendone.service.CategoryService;
import com.website.backendone.service.ProductService;
import com.website.backendone.service.ReviewService;
import com.website.backendone.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private ProductController underTest;
    @Mock private ProductService productService;

    @BeforeEach
    void setUp() {
        underTest = new ProductController(productService);
    }

    @Test
    void getProduct() {
        // Given
        Integer id = 1;

        // When
        underTest.getProduct(id);

        // Then
        verify(productService).getProductById(id);
    }

    @Test
    void getProducts() {
        // Given
        List<Integer> ids = List.of(1, 2, 3, 4);

        // When
        underTest.getProducts(ids);

        // Then
        verify(productService).getProductById(1);
        verify(productService).getProductById(2);
        verify(productService).getProductById(3);
        verify(productService).getProductById(4);
    }
}