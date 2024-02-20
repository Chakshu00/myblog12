package com.myblog.myblog12;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication //starting point where the spring boot starts
public class Myblog12Application {
	public static void main(String[] args) {
		SpringApplication.run(Myblog12Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
