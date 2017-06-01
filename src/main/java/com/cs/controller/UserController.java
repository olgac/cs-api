package com.cs.controller;

import com.cs.model.request.LoginRequest;
import com.cs.model.response.LoginResponse;
import com.cs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by olgac on 31/05/2017.
 */
@RestController
@RequestMapping("/user")
@Api(description = "User operations")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("Login")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<LoginResponse>(userService.login(loginRequest), HttpStatus.OK);
    }
}