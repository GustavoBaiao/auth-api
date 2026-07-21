package com.gustavobaiao.auth_api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponseDTO(

        @Schema(description = "The JWT token for the authenticated user", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpX")
        String token
) {
}
