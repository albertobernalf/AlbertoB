package com.callcenter1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;



@SpringBootApplication(scanBasePackages = {"com.callcenter1"})
@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource({  "classpath:application.properties" })



public class Callcenter1Application {

	public static void main(String[] args) {
		SpringApplication.run(Callcenter1Application.class, args);
	}
}
