package com.website.backendone.service;

import com.website.backendone.entity.Review;
import com.website.backendone.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository repository;

    public void addReview(Review review) {
        repository.save(review);
    }

    public void deleteReviewById(Integer id) {
        repository.deleteById(id);
    }
}
