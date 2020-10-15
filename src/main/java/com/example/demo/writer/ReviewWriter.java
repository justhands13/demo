package com.example.demo.writer;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import java.util.List;

public class ReviewWriter
        implements ItemWriter<Review>
{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void write(List<? extends Review> list) throws Exception {
        reviewRepository.saveAll(list);

    }
//    public FlatFileItemWriter<Review> write() {
//        return new FlatFileItemWriterBuilder<Review>()
////                .name("personItemWriter")
//                .resource(new FileSystemResource("src/main/resources/output/billboard.txt"))
//                .delimited()
//                .delimiter(",")
//                .names(new String[] {"name", "criticScore", "audienceScore"})
//                .build();
//    }
}
