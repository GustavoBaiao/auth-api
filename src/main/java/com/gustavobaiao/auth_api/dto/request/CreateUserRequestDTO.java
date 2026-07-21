package com.gustavobaiao.auth_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request DTO for creating a new user")
public record CreateUserRequestDTO(

    @NotBlank
    @Schema(description = "The name of the new user", example = "John Doe")
    String name,

    @NotBlank
    @Email
    @Schema(description = "The email of the new user", example = "john.doe@example.com")
    String email,

    @NotBlank
    @Schema(description = "The password of the new user", example = "Password@123")
    String password,

    @NotNull
    @Schema(description = "Indicates if the user has accepted the terms and conditions", example = "true")
    Boolean termsAccepted
) {
}
