package com.example.demo.processor;

import com.example.demo.model.Review;
import org.springframework.batch.item.ItemProcessor;

public class ReviewProcessor implements ItemProcessor<Review, Review> {

    @Override
    public Review process(Review review) throws Exception {
//        System.out.println(review.getName());
//        System.out.println("imside processor");
        return review;
    }
}
