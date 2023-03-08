package com.website.backendone.service;

import com.website.backendone.repository.SectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SectionServiceTest {

    private SectionService underTest;
    @Mock SectionRepository sectionRepository;

    @BeforeEach
    void setUp() {
        underTest = new com.website.backendone.service.SectionService(sectionRepository);
    }

    @Test
    void getAllSections_ShouldInvokeRepositoryFunction() {
        // When
        underTest.getAllSections();

        // Then
        verify(sectionRepository).findAll();
    }

    @Test
    void getSectionById_ShouldInvokeRepositoryFunction() {
        // Given
        Integer id = 1;

        // When
        underTest.getSectionById(id);

        // Then
        ArgumentCaptor<Integer> idArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(sectionRepository).findById(idArgumentCaptor.capture());
        Integer capturedId = idArgumentCaptor.getValue();
        assert(capturedId.equals(id));
    }
}