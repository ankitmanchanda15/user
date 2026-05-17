package com.client.app.service;

import com.client.app.dto.UserRegistrationRequest;
import com.client.app.dto.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRegistrationRequest request);
}