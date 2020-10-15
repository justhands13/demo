package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//		(
//		exclude = {DataSourceAutoConfiguration.class}
//		,scanBasePackages={
//				"package com.example.demo.config;"
//				,"package com.example.demo.controller;"
//				,"package com.example.demo.model;"
//				,"package com.example.demo.processor;"
//				,"package com.example.demo.reader;"
//				,"package com.example.demo.repository;"
//				,"package com.example.demo.writer;"
//			}
//
//		)


public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
