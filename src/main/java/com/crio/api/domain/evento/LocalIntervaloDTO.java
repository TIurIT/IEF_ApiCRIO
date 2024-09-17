package com.crio.api.domain.evento;


import java.time.LocalDateTime;

public record LocalIntervaloDTO(
        String Local,
        LocalDateTime inicio,
        LocalDateTime fim
) {
}
