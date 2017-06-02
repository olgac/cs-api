package com.cs.service;

import com.cs.model.request.LoginRequest;
import com.cs.model.response.LoginResponse;

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by olgac on 31/05/2017.
 */
public interface UserService {

    Future<Optional<LoginResponse>> login(LoginRequest loginRequest);

}
