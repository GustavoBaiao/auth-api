package com.gustavobaiao.auth_api.service.iml;

import com.gustavobaiao.auth_api.dto.request.CreateUserRequestDTO;
import com.gustavobaiao.auth_api.dto.response.UserResponseDTO;
import com.gustavobaiao.auth_api.entity.UserEntity;
import com.gustavobaiao.auth_api.exception.EmailAlreadyExistsException;
import com.gustavobaiao.auth_api.exception.TermsNotAcceptedException;
import com.gustavobaiao.auth_api.mapper.IUserMapper;
import com.gustavobaiao.auth_api.repository.IUserRepository;
import com.gustavobaiao.auth_api.service.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthService implements IAuthService {

    private final IUserRepository userRepository;

    private final IUserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO register(CreateUserRequestDTO request) {
        log.info("Registering user: {}", request.name());

        validateEmail(request);

        validateTermsAccepted(request);

        var user = mapToEntity(request);
        var savedUser = save(user);

        return mapToDto(savedUser);
    }

    private void validateTermsAccepted(CreateUserRequestDTO request) {
        if (!request.termsAccepted()) {
            log.info("User did not accept terms: {}", request.email());
            throw new TermsNotAcceptedException("Usuário não aceitou os termos de uso");
        }
    }

    private void validateEmail(CreateUserRequestDTO request) {
        if (userRepository.existsByEmail(request.email())) {
            log.info("User already exists: {}", request.email());
            throw new EmailAlreadyExistsException("Email já existe");
        }
    }

    private UserEntity save(UserEntity userEntity) {
        log.info("Saving user: {}", userEntity.getName());
        return userRepository.save(userEntity);
    }

    private UserEntity mapToEntity(CreateUserRequestDTO request) {
        log.info("Mapping user request to entity: {}", request.name());
        UserEntity userEntity = userMapper.toEntity(request);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntity;
    }

    private UserResponseDTO mapToDto(UserEntity userEntity) {
        log.info("Mapping user to dto: {}", userEntity.getName());
        return userMapper.toDto(userEntity);
    }
}