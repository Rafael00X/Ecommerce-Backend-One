package com.website.backendone.service;

import com.website.backendone.entity.Product;
import com.website.backendone.entity.Review;
import com.website.backendone.repository.ProductRepository;
import com.website.backendone.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private ReviewRepository repository;

    @Autowired
    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public void addReview(Review review) {
        repository.save(review);
    }

    public String deleteReviewById(Integer id) {
        repository.deleteById(id);
        return "Review deleted successfully!";
    }
}
