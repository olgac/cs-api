package com.cs.service;

import com.cs.model.request.LoginRequest;
import com.cs.model.response.LoginResponse;

/**
 * Created by olgac on 31/05/2017.
 */
public interface UserService {

    LoginResponse login(LoginRequest loginRequest);

}
