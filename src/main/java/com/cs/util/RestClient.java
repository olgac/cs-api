package com.cs.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by olgac on 31/05/2017.
 */
public class RestClient {

    @Value("${rest.base}")
    private String baseUrl;

    private RestTemplate restTemplate;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> Future<Optional<T>> post(String path, String token, Object request, Class<T> responseType) {
        return post(path, addAuthorizationHeader(token, request), responseType);
    }

    public <T> Future<Optional<T>> post(String path, Object request, Class<T> responseType) {
        return new AsyncResult<>(Optional.ofNullable(restTemplate.postForObject(baseUrl.concat(path), request, responseType)));
    }

    private <T> HttpEntity<T> addAuthorizationHeader(String token, T request) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add(HttpHeaders.AUTHORIZATION, token);
        return new HttpEntity<>(request, header);
    }
}