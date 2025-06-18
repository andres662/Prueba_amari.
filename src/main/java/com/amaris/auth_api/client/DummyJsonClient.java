package com.amaris.auth_api.client;


import com.amaris.auth_api.dto.LoginRequest;
import com.amaris.auth_api.dto.LoginResponse;
import com.amaris.auth_api.dto.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "dummyClient", url = "https://dummyjson.com")
public interface DummyJsonClient {

    @PostMapping("/auth/login")
    LoginResponse login(@RequestBody LoginRequest request);

    @GetMapping("/auth/me")
    UserInfoResponse getUserInfo(@RequestHeader("Authorization") String token);
}

