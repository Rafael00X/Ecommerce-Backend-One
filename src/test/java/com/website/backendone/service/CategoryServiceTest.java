package com.website.backendone.service;

import com.website.backendone.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    private CategoryService underTest;
    @Mock private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        underTest = new com.website.backendone.service.CategoryService(categoryRepository);
    }

    @Test
    void getCategoryById_ShouldInvokeRepositoryFunction() {
        // Given
        Integer id = 1;

        // When
        underTest.getCategoryById(id);

        // Then
        ArgumentCaptor<Integer> idArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(categoryRepository).findById(idArgumentCaptor.capture());
        Integer capturedId = idArgumentCaptor.getValue();
        assert(capturedId.equals(id));
    }

}