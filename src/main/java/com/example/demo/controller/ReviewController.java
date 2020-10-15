package com.example.demo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billboard")
public class ReviewController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @RequestMapping(value = "/param",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void launch(@RequestParam("param") String name) throws Exception{
        JobParameters jobParameters =new JobParametersBuilder()
                                        .addString("name",name)
                                        .toJobParameters();
        this.jobLauncher.run(job,jobParameters);
    }

}
