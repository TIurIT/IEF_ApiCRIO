package com.crio.api.service;

import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.evento.EventoRequestDTO;
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

    public Evento getEventsById(UUID id) {
        return  eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }
}
