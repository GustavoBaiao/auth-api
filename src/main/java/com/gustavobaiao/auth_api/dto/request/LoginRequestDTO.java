package com.gustavobaiao.auth_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request DTO for user login")
public record LoginRequestDTO(

        @NotBlank
        @Email
        @Schema(description = "The email of the user", example = "john.doe@example.com")
        String email,

        @NotBlank
        @Schema(description = "The password of the user", example = "Password@123")
        String password
) {
}
