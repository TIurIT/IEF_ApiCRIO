package com.crio.api.service;

import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.evento.EventoRequestDTO;
import com.crio.api.domain.evento.EventoResponseDTO;
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
        newEvento.setLocal(data.local());
        newEvento.setPrivado(data.privado());
        newEvento.setLinkEvento(data.linkEvento());
        newEvento.setComoChegar(data.comoChegar());
        newEvento.setLinkForms(data.linkForms());
        newEvento.setUsuario(data.usuario());
        newEvento.setEndereco(data.endereco());
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
        updatedEvento.setLocal(eventoResponseDTO.local());
        updatedEvento.setPrivado(eventoResponseDTO.privado());
        updatedEvento.setLinkEvento(eventoResponseDTO.linkEvento());
        updatedEvento.setComoChegar(eventoResponseDTO.comoChegar());
        updatedEvento.setLinkForms(eventoResponseDTO.linkForms());
        updatedEvento.setUsuario(eventoResponseDTO.usuario());
        updatedEvento.setEndereco(eventoResponseDTO.endereco());

        return eventoRepository.save(updatedEvento);
    }

    public void deleteEvent(UUID id){
        Evento evento = getEventById(id);
        eventoRepository.delete(evento);
    }
}
