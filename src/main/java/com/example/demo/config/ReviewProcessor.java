package com.example.demo.config;

import com.example.demo.model.Review;
import org.springframework.batch.item.ItemProcessor;

public class ReviewProcessor implements ItemProcessor<Review, Review> {

    @Override
    public Review process(Review review) throws Exception {
        return review;
    }
}
