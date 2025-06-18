package com.amaris.auth_api.controller;

import com.amaris.auth_api.dto.LoginRequest;
import com.amaris.auth_api.dto.UserInfoResponse;
import com.amaris.auth_api.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<UserInfoResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.loginAndSave(request));
    }
}
