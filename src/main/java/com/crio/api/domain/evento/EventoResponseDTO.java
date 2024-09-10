package com.crio.api.domain.evento;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponseDTO(
        UUID id,
        String titulo,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        int publicoAlvo,
        String local,
        boolean privado
) {
}
