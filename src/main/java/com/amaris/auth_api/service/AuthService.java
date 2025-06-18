package com.amaris.auth_api.service;

import com.amaris.auth_api.dto.LoginRequest;
import com.amaris.auth_api.dto.UserInfoResponse;

public interface AuthService {
    UserInfoResponse loginAndSave(LoginRequest request);
}
