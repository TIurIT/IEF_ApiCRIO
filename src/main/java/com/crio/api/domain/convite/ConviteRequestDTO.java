package com.crio.api.domain.convite;

import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.usuario.Usuario;

public record ConviteRequestDTO(
        boolean confirmacaoPresenca,
        Evento evento,
        Usuario usuario
) {
}
