package com.cs;

import com.cs.util.ErrorHandler;
import com.cs.util.RestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@EnableAsync
@SpringBootApplication
public class Application extends AsyncConfigurerSupport {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("CS-");
        executor.initialize();
        return executor;
    }

    @Bean
    public RestClient restClient() {
        RestTemplate restTemplate =  new RestTemplate();
        restTemplate.setErrorHandler(new ErrorHandler());
        return new RestClient(restTemplate);
    }
}