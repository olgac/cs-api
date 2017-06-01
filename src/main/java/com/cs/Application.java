package com.cs;

import com.cs.util.ErrorHandler;
import com.cs.util.RestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	@Bean
    public RestClient restClient(RestTemplateBuilder builder) {
        RestTemplate restTemplate =  builder.build();
        restTemplate.setErrorHandler(new ErrorHandler());
        return new RestClient(restTemplate);
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}