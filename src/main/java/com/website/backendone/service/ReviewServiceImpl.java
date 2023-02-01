package com.website.backendone.service;

import com.website.backendone.entity.Review;
import com.website.backendone.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository repository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    public void addReview(Review review) {
        repository.save(review);
    }

    public void deleteReviewById(Integer id) {
        repository.deleteById(id);
    }
}
