package com.crio.api.domain.evento;

import java.time.LocalDateTime;

public record EventoRequestDTO(
        String titulo,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        int publicoAlvo,
        String local,
        boolean privado
) {
}
