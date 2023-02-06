package com.website.backendone.controller;

import com.website.backendone.entity.Product;
import com.website.backendone.entity.Review;
import com.website.backendone.entity.Section;
import com.website.backendone.service.CategoryService;
import com.website.backendone.service.ProductService;
import com.website.backendone.service.ReviewService;
import com.website.backendone.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StoreControllerTest {

    private StoreController underTest;
    @Mock private CategoryService categoryService;
    @Mock private ProductService productService;
    @Mock private ReviewService reviewService;
    @Mock private SectionService sectionService;

    @BeforeEach
    void setUp() {
        underTest = new StoreController(categoryService, productService, sectionService, reviewService);
    }

    @Test
    void getAllSections() {
        // When
        underTest.getAllSections();

        // Then
        verify(sectionService).getAllSections();
    }

    @Test
    void getSection() {
        // Given
        Integer id = 1;

        // When
        underTest.getSection(id);

        // Then
        verify(sectionService).getSectionById(id);
    }

    @Test
    void getCategory() {
        // Given
        Integer id = 1;

        // When
        underTest.getCategory(id);

        // Then
        verify(categoryService).getCategoryById(id);
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