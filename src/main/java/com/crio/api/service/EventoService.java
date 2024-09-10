package com.crio.api.service;

import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.evento.EventoRequestDTO;
import com.crio.api.domain.evento.EventoResponseDTO;
import com.crio.api.domain.usuario.Usuario;
import com.crio.api.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento createEvento(EventoRequestDTO data){
        Evento newEvento = new Evento();
        newEvento.setTitulo(data.titulo());
        newEvento.setDescricao(data.descricao());
        newEvento.setInicio(data.inicio());
        newEvento.setFim(data.fim());
        newEvento.setPublicoAlvo(data.publicoAlvo());
        newEvento.setLocal(data.local());
        newEvento.setPrivado(data.privado());
        eventoRepository.save(newEvento);

        return  newEvento;
    }

    public List<Evento> getAllEvents() {
        return eventoRepository.findAll();
    }

    public Evento getEventById(UUID id) {
        return  eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    public Evento updateEvent(UUID id, EventoResponseDTO eventoResponseDTO){
        Evento updatedEvento = getEventById(id);
        updatedEvento.setTitulo(eventoResponseDTO.titulo());
        updatedEvento.setDescricao(eventoResponseDTO.descricao());
        updatedEvento.setInicio(eventoResponseDTO.inicio());
        updatedEvento.setFim(eventoResponseDTO.fim());
        updatedEvento.setPublicoAlvo(eventoResponseDTO.publicoAlvo());
        updatedEvento.setLocal(eventoResponseDTO.local());
        updatedEvento.setPrivado(eventoResponseDTO.privado());

        return eventoRepository.save(updatedEvento);
    }

    public void deleteEvent(UUID id){
        Evento evento = getEventById(id);
        eventoRepository.delete(evento);
    }
}
