package com.example.demo.writer;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewWriter implements ItemWriter<Review> {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void write(List<? extends Review> list) throws Exception {
//        for(Review item : list){
//            ObjectMapper objectMapper = new ObjectMapper();
//            String jsonString = objectMapper.writeValueAsString(item);
//            System.out.println(jsonString);
//        }
//        Thread.sleep(5000);
//        System.out.println("i shouldn't be here");
        reviewRepository.saveAll(list);

    }
}
