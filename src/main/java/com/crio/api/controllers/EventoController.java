package com.crio.api.controllers;

import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.evento.EventoRequestDTO;
import com.crio.api.domain.usuario.Usuario;
import com.crio.api.domain.usuario.UsuarioRequestDTO;
import com.crio.api.service.EventoService;
import com.crio.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Evento> create(
            @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao,
            @RequestParam("inicio") LocalDateTime inicio,
            @RequestParam("fim") LocalDateTime fim,
            @RequestParam("publicoAlvo") int publicoAlvo,
            @RequestParam("local") String local,
            @RequestParam("privado") boolean privado
    ) {

        EventoRequestDTO eventoRequestDTO = new EventoRequestDTO(titulo, descricao, inicio, fim, publicoAlvo, local, privado);

        Evento newEvento = this.eventoService.createEvento(eventoRequestDTO);

        return ResponseEntity.ok(newEvento);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEvents(){
        List<Evento> eventos = this.eventoService.getAllEvents();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventById(@PathVariable("id")UUID id) {
        Evento evento = this.eventoService.getEventById(id);
        return ResponseEntity.ok(evento);
    }
}
