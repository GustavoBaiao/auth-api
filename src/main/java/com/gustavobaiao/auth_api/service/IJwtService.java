package com.gustavobaiao.auth_api.service;

public interface IJwtService {

    String generateToken(String email);

    String extractUsername(String token);

    boolean isTokenValid(String token);
}
