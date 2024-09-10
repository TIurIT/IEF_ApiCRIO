package com.crio.api.domain.evento;

import com.crio.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record EventoRequestDTO(
        String titulo,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        int publicoAlvo,
        String local,
        boolean privado,
        Usuario usuario
) {
}
