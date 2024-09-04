package com.crio.api.repositories;

import com.crio.api.domain.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository <Evento, UUID> {

    //findEventobyTitle() implementar
    //findEventobyDate()
}
