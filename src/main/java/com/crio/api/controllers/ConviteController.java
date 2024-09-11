package com.crio.api.controllers;

import com.crio.api.domain.convite.Convite;
import com.crio.api.domain.convite.ConviteRequestDTO;
import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.usuario.Usuario;
import com.crio.api.repositories.ConviteRepository;
import com.crio.api.service.ConviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/convite")
public class ConviteController {

    @Autowired
     private ConviteService conviteService;

    @PostMapping(consumes = "multipart/from-data")
    public ResponseEntity<Convite> create(
            @RequestParam("confirmacaoPresenca") boolean confirmacaoPresenca,
            @RequestParam("evento") Evento evento,
            @RequestParam("usuario") Usuario usuario
            ){

        ConviteRequestDTO conviteRequestDTO = new ConviteRequestDTO(confirmacaoPresenca, evento, usuario);

        Convite newConvite = this.conviteService.createConvite(conviteRequestDTO);

        return ResponseEntity.ok(newConvite);
    }


}
