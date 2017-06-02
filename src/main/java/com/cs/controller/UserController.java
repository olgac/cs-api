package com.cs.controller;

import com.cs.constants.Status;
import com.cs.model.error.Error;
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
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by olgac on 31/05/2017.
 */
@RestController
@RequestMapping("/user")
@Api(description = "User Operations")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("Login End-Point")
    @PostMapping("/login")
    public Callable<ResponseEntity<LoginResponse>> login(@Valid @RequestBody LoginRequest loginRequest) {
        return () -> {
            Future<Optional<LoginResponse>> future = userService.login(loginRequest);
            Optional<LoginResponse> optional = future.get();
            return new ResponseEntity<>(optional.orElseThrow(() -> new Error(0, Status.ERROR, "User not retrieved!")), HttpStatus.OK);
        };
    }
}