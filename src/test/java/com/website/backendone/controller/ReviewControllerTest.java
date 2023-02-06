package com.website.backendone.controller;

import com.website.backendone.entity.Product;
import com.website.backendone.entity.Review;
import com.website.backendone.model.User;
import com.website.backendone.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewControllerTest {

    private ReviewController underTest;
    @Mock private FetchService fetchService;
    @Mock private ProductService productService;
    @Mock private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        underTest = new ReviewController(fetchService, productService, reviewService);
    }

    @Test
    void addReview() {
        // Given
        Product product = new Product();
        product.setProductId(1);
        Review review = new Review();
        review.setUserId(1);
        review.setProduct(product);
        String token = "jwt-token";
        User tokenUser = new User();
        tokenUser.setUserId(1);
        when(fetchService.validateToken(token)).thenReturn(tokenUser);

        // When
        underTest.addReview(token, review);

        // Then
        ArgumentCaptor<Review> reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        verify(reviewService).addReview(reviewArgumentCaptor.capture());
        Review capturedReview = reviewArgumentCaptor.getValue();
        assert(capturedReview.equals(review));
    }

    @Test
    void deleteReview() {
        // Given
        Product product = new Product();
        product.setProductId(1);
        Review review = new Review();
        review.setReviewId(1);
        review.setUserId(1);
        review.setProduct(product);
        String token = "jwt-token";
        User tokenUser = new User();
        tokenUser.setUserId(1);
        when(fetchService.validateToken(token)).thenReturn(tokenUser);

        // When
        underTest.deleteReview(token, review);

        // Then
        ArgumentCaptor<Integer> idArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(reviewService).deleteReviewById(idArgumentCaptor.capture());
        Integer capturedId = idArgumentCaptor.getValue();
        assert(capturedId.equals(review.getReviewId()));
    }
}