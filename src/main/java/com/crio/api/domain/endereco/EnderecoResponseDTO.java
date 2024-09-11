package com.crio.api.domain.endereco;

import java.util.UUID;

public record EnderecoResponseDTO(
        UUID id,
        String cidade,
        String uf
) {
}
