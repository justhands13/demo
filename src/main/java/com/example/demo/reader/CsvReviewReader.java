package com.example.demo.reader;

import com.example.demo.model.Review;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.core.io.ClassPathResource;

public class CsvReviewReader {
    public FlatFileItemReader<Review> read() {
        return new FlatFileItemReaderBuilder<Review>()
                .linesToSkip(1)
                .name("ReviewItemReader")
                .resource(new ClassPathResource("csv/series-review.csv"))
                .delimited()
                .names(new String[] {"name", "criticScore", "audienceScore"})
                .targetType(Review.class)
                .build();
    }
}
