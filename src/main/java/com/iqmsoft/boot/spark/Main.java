package com.iqmsoft.boot.spark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.iqmsoft.boot.spark.config.SparkConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = SparkConfiguration.class)
@Import(SparkConfiguration.class)
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
