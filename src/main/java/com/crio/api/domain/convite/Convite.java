package com.crio.api.domain.convite;


import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "convite")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Convite {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "confirmacaoPresenca")
    private boolean confirmacaoPresenca;

    @OneToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
