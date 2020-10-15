package com.example.demo.config;

import com.example.demo.model.Review;
import com.example.demo.processor.ReviewProcessor;
import com.example.demo.reader.CsvReviewReader;
import com.example.demo.writer.ReviewWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.ResponseStatus;

@Configuration
public class JobConfiguration {

    @Value("$app.csv.fileHeaders")
    String[] name;



    @Bean
    public Job demoJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        return jobBuilderFactory.get("firstjob")
                .start(step1(stepBuilderFactory))
                .next(step2(stepBuilderFactory))
                .build();
    }

    @Bean
    public Step step1 (StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("tasklet")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();

                        System.out.println("The job was called by " + jobParameters);
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

    @Bean
    public Step step2(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("csv-to-txt")
                .<Review, Review>chunk(10)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public FlatFileItemReader<Review> itemReader() {
        CsvReviewReader csvReviewReader= new CsvReviewReader();
        return csvReviewReader.read();
    }

    @Bean
    public ReviewProcessor itemProcessor() {
        return new ReviewProcessor();
    }

    @Bean
    public FlatFileItemWriter<Review> itemWriter() {
        ReviewWriter reviewWriter = new ReviewWriter();
        return reviewWriter.write();
    }
}
