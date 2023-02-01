package com.website.backendone.service;

import com.website.backendone.entity.Review;

public interface ReviewService {
    void addReview(Review review);
    void deleteReviewById(Integer id);
}
