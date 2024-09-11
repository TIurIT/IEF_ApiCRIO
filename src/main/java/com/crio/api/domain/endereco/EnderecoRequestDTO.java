package com.crio.api.domain.endereco;

import java.util.UUID;

public record EnderecoRequestDTO(
        String cidade,
        String uf
) {
}
