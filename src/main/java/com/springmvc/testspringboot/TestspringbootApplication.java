package com.springmvc.testspringboot;

import java.io.IOException;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.springmvc.testspringboot")
@SpringBootApplication
public class TestspringbootApplication {

	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(TestspringbootApplication.class, args);

	}

}
