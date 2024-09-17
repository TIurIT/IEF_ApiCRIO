package com.crio.api.domain.usuario;

import java.time.LocalDateTime;

public record CreatedBetweenDTO(
        LocalDateTime createdAt,
        LocalDateTime fim
) {
}
