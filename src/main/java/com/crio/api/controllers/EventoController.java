package com.crio.api.controllers;

import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.evento.*;
import com.crio.api.domain.usuario.Usuario;
import com.crio.api.service.EventoService;
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

    //Querys
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Evento>> findByUsuarioId(@PathVariable
                                                        UUID usuarioId){
        List<Evento> eventos = eventoService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(eventos);
    }
    //buscar evento por intervalo de data
    @PostMapping("/intervalo")
    public ResponseEntity<List<Evento>> findByIntervaloData(
            @RequestBody IntervaloDataDTO intervaloDataDTO){
        List<Evento> eventos = eventoService.findByIntervaloData(
                intervaloDataDTO);
        return ResponseEntity.ok(eventos);
    }
    //buscar eventos por local
    @GetMapping("/local/{local}")
    public ResponseEntity<List<Evento>> findByLocal(
            @PathVariable String local){
        List<Evento> eventos = eventoService.findByLocal(local);
        return ResponseEntity.ok(eventos);
    }
    @PostMapping("/local-intervalo")
    public ResponseEntity<List<Evento>> findByLocalAndIntervaloData(
            @RequestBody LocalIntervaloDTO localIntervaloDTO){
        List<Evento> eventos = eventoService.findByLocalAndIntervaloData(
                localIntervaloDTO.Local(),
                localIntervaloDTO.inicio(),
                localIntervaloDTO.fim() );
        return ResponseEntity.ok(eventos);
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Evento> create(
            @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao,
            @RequestParam("inicio") LocalDateTime inicio,
            @RequestParam("fim") LocalDateTime fim,
            @RequestParam("local") String local,
            @RequestParam("privado") boolean privado,
            @RequestParam("linkEvento") String linkEvento,
            @RequestParam("comoChegar") String comoChegar,
            @RequestParam("linkForms") String linkForms,
            @RequestParam("usuario") Usuario usuario,
            @RequestParam("endereco") Endereco endereco
    ) {

        EventoRequestDTO eventoRequestDTO = new EventoRequestDTO(titulo, descricao, inicio, fim, local, privado, linkEvento, comoChegar, linkForms, usuario, endereco);

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

    @PutMapping("/{id}")
        public ResponseEntity<Evento> updateEvent(@PathVariable("id")UUID id, EventoResponseDTO eventoResponseDTO){
        Evento updateEvent = this.eventoService.updateEvent(id, eventoResponseDTO );
        return ResponseEntity.ok(updateEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id")UUID id) {
        this.eventoService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
