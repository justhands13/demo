package com.example.demo.writer;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewWriter implements ItemWriter<Review> {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void write(List<? extends Review> list) throws Exception {
        reviewRepository.saveAll(list);

    }
}
