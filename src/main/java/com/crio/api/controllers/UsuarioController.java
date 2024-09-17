package com.crio.api.controllers;


import com.crio.api.domain.usuario.CreatedBetweenDTO;
import com.crio.api.domain.usuario.Usuario;
import com.crio.api.domain.usuario.UsuarioRequestDTO;
import com.crio.api.domain.usuario.UsuarioResponseDTO;
import com.crio.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// @Controller Controla o fluxo de dados sendo eles imagens,infos e etc.
@RestController// Controla o fluxo de dados apenas em JSON
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Querys
    @GetMapping("/email")
    public ResponseEntity<List<Usuario>> findByEmail(@PathVariable String email){
        List<Usuario> usuarios = usuarioService.findByEmail(email);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/tipo")
    public ResponseEntity<List<Usuario>> findByTipo(@PathVariable int tipo){
        List<Usuario> usuarios = usuarioService.findByTipo(tipo);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Usuario>> findByCreatedAtBetween(@RequestBody CreatedBetweenDTO createdBetweenDTO){
        List<Usuario> usuarios = usuarioService.findByCreatedAtBetween(
                createdBetweenDTO.createdAt(),
                createdBetweenDTO.fim() );
        return ResponseEntity.ok(usuarios);
    }


    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Usuario> create(
            @RequestParam("nomeCompleto") String nomeCompleto,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("tipo") int tipo){

        UsuarioRequestDTO usuarioRequestDTO = new UsuarioRequestDTO(nomeCompleto, email, senha, tipo);

        Usuario newUsuario = this.usuarioService.createUsuario(usuarioRequestDTO);

        return ResponseEntity.ok(newUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> usuarios = this.usuarioService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id")UUID id){
        Usuario usuario = this.usuarioService.getUserById(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable("id")UUID id, UsuarioResponseDTO usuarioResponseDTO){
        Usuario updatedUsuario = this.usuarioService.updateUser(id, usuarioResponseDTO );
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")UUID id){
        this.usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
