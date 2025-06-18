package com.amaris.auth_api.service;

import com.amaris.auth_api.client.DummyJsonClient;
import com.amaris.auth_api.dto.LoginRequest;
import com.amaris.auth_api.dto.LoginResponse;
import com.amaris.auth_api.dto.UserInfoResponse;
import com.amaris.auth_api.entity.LoginLog;
import com.amaris.auth_api.repository.LoginLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    private final DummyJsonClient dummyClient;
    private final LoginLogRepository logRepo;

    public AuthServiceImpl(DummyJsonClient dummyClient, LoginLogRepository logRepo) {
        this.dummyClient = dummyClient;
        this.logRepo = logRepo;
    }

    public UserInfoResponse loginAndSave(LoginRequest request) {
        LoginResponse response = dummyClient.login(request);

        LoginLog log = new LoginLog();
        log.setUsername(response.getUsername());
        log.setAccessToken(response.getToken());
        log.setLoginTime(LocalDateTime.now());
        logRepo.save(log);

        return dummyClient.getUserInfo("Bearer " + response.getToken());
    }
}
