package com.cs.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

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

    public <T> T post(String path, String token, Object request, Class<T> responseType) {
        return post(path, addAuthorizationHeader(token, request), responseType);
    }

    public <T> T post(String path, Object request, Class<T> responseType) {
        return restTemplate.postForObject(baseUrl.concat(path), request, responseType);
    }

    private <T> HttpEntity<T> addAuthorizationHeader(String token, T request) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add(HttpHeaders.AUTHORIZATION, token);
        return new HttpEntity<T>(request, header);
    }
}