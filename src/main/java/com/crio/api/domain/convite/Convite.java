package com.crio.api.domain.convite;


import com.crio.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table(name = "convite")
@Entity
@Getter
@Setter
public class Convite {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "confirmacaoPresenca")
    private boolean confirmacaoPresenca;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
