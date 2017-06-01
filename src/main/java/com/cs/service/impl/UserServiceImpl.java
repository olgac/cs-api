package com.cs.service.impl;

import com.cs.model.request.LoginRequest;
import com.cs.model.response.LoginResponse;
import com.cs.service.UserService;
import com.cs.util.RestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by olgac on 31/05/2017.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Value("${rest.login}")
    private String loginPath;

    @Autowired
    private RestClient rest;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return rest.post(loginPath, loginRequest, LoginResponse.class);
    }
}