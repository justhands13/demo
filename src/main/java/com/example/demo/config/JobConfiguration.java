package com.example.demo.config;

import com.example.demo.model.Review;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class JobConfiguration {

    @Value("$app.csv.fileHeaders")
    String[] name;

    @Bean
    public Job convertNamesJob(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders) {
        return jobBuilders.get("firstjob")
                .start(convertNamesStep(stepBuilders))
                .build();
    }

    @Bean
    public Step convertNamesStep(StepBuilderFactory stepBuilders) {
        return stepBuilders.get("csv-to-txt")
                .<Review, Review>chunk(10)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public FlatFileItemReader<Review> itemReader() {
        return new FlatFileItemReaderBuilder<Review>()
                .linesToSkip(1)
                .name("ReviewItemReader")
                .resource(new ClassPathResource("csv/series-review.csv"))
                .delimited()
                .names(new String[] {"name", "criticScore", "audienceScore"})
                .targetType(Review.class)
                .build();
    }

    @Bean
    public ReviewProcessor itemProcessor() {
        return new ReviewProcessor();
    }

    @Bean
    public FlatFileItemWriter<Review> itemWriter() {
        return new FlatFileItemWriterBuilder<Review>()
                .name("personItemWriter")
                .resource(new FileSystemResource("src/main/resources/output/billboard.txt"))
                .delimited()
                .delimiter(",")
                .names(new String[] {"name", "criticScore", "audienceScore"})
                .build();
    }
}
