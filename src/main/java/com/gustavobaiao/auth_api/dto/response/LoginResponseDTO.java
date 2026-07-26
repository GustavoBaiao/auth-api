package com.gustavobaiao.auth_api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponseDTO(

        @Schema(description = "The message for the login response")
        String message

) {
}
