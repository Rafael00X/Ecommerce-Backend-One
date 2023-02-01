package com.website.backendone.service;

import com.website.backendone.entity.Review;
import com.website.backendone.repository.ReviewRepository;
import com.website.backendone.service.impl.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {
    private ReviewService underTest;
    @Mock private ReviewRepository reviewRepository;

    @BeforeEach
    void setUp() {
        underTest = new ReviewServiceImpl(reviewRepository);
    }

    @Test
    void addReview_ShouldInvokeRepositoryMethod() {
        // Given
        Review review = new Review(1, 1, "User1", 3, "Nice Product!", null, null);

        // When
        underTest.addReview(review);

        // Then
        ArgumentCaptor<Review> reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        verify(reviewRepository).save(reviewArgumentCaptor.capture());
        Review capturedReview = reviewArgumentCaptor.getValue();
        assert(capturedReview.equals(review));
    }

    @Test
    void deleteReviewById_ShouldInvokeRepositoryMethod() {
        // Given
        Integer id = 1;

        // When
        underTest.deleteReviewById(id);

        // Then
        ArgumentCaptor<Integer> idArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(reviewRepository).deleteById(idArgumentCaptor.capture());
        Integer capturedId = idArgumentCaptor.getValue();
        assert(capturedId.equals(id));
    }
}