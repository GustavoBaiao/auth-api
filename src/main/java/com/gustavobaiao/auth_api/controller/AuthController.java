package com.gustavobaiao.auth_api.controller;

import com.gustavobaiao.auth_api.dto.request.CreateUserRequestDTO;
import com.gustavobaiao.auth_api.dto.response.UserResponseDTO;
import com.gustavobaiao.auth_api.service.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid CreateUserRequestDTO request) {
        var userResponse = authService.register(request);
        var location = URI.create("/auth/register/" + userResponse.id());
        MDC.clear();
        return ResponseEntity.created(location).body(userResponse);
    }
}
