package com.website.backendone.service;

import com.website.backendone.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private ProductService underTest;
    @Mock private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        underTest = new com.website.backendone.service.ProductService(productRepository);
    }

    @Test
    void getProductById_ShouldInvokeRepositoryFunction() {
        // Given
        Integer id = 1;

        // When
        underTest.getProductById(id);

        // Then
        verify(productRepository).findById(id);
    }
}