package com.gustavobaiao.auth_api.service;

import com.gustavobaiao.auth_api.dto.request.CreateUserRequestDTO;
import com.gustavobaiao.auth_api.dto.request.LoginRequestDTO;
import com.gustavobaiao.auth_api.dto.response.LoginResponseDTO;
import com.gustavobaiao.auth_api.dto.response.UserResponseDTO;

public interface IAuthService {

    UserResponseDTO register(CreateUserRequestDTO request);

    LoginResponseDTO login(LoginRequestDTO request);

}
