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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SectionControllerTest {

    private SectionController underTest;
    @Mock private SectionService sectionService;

    @BeforeEach
    void setUp() {
        underTest = new SectionController(sectionService);
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
}