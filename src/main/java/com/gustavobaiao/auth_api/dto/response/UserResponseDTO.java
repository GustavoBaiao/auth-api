package com.gustavobaiao.auth_api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Response DTO for user information")
public record UserResponseDTO(

        @Schema(description = "The unique identifier of the user")
        UUID id,

        @Schema(description = "The name of the user")
        String name,

        @Schema(description = "The email of the user")
        String email,

        @Schema(description = "Indicates if the user has accepted the terms and conditions")
        Boolean termsAccepted,

        @Schema(description = "The date and time the user was created")
        LocalDateTime createdAt
) {
}
