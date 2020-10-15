package com.example.demo.writer;

import com.example.demo.model.Review;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.core.io.FileSystemResource;

public class ReviewWriter {
    public FlatFileItemWriter<Review> write() {
        return new FlatFileItemWriterBuilder<Review>()
                .name("personItemWriter")
                .resource(new FileSystemResource("src/main/resources/output/billboard.txt"))
                .delimited()
                .delimiter(",")
                .names(new String[] {"name", "criticScore", "audienceScore"})
                .build();
    }
}
