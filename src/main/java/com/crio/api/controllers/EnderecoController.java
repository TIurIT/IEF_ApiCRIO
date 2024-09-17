package com.crio.api.controllers;


import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.endereco.EnderecoRequestDTO;
import com.crio.api.domain.endereco.EnderecoResponseDTO;
import com.crio.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    //Querys
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Endereco>> findByCidade(@PathVariable String cidade){
        List<Endereco> enderecos = enderecoService.findByCity(cidade);
        return  ResponseEntity.ok(enderecos);
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Endereco>> findByUf(@PathVariable String uf){
        List<Endereco> enderecos = enderecoService.findByUf(uf);
        return  ResponseEntity.ok(enderecos);
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Endereco> create(
            @RequestParam("cidade") String cidade,
            @RequestParam("uf") String uf

    ){
        EnderecoRequestDTO EnderecoRequestDTO = new EnderecoRequestDTO(cidade, uf);

        Endereco newEndereco = this.enderecoService.createEndereco(EnderecoRequestDTO);

        return ResponseEntity.ok(newEndereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos(){
        List<Endereco> Enderecos = this.enderecoService.getAllEnderecos();
        return ResponseEntity.ok(Enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable("id") UUID id){
        Endereco Endereco = this.enderecoService.getEnderecoById(id);
        return ResponseEntity.ok(Endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable("id")UUID id, EnderecoResponseDTO EnderecoResponseDTO){
        Endereco updatedEndereco = this.enderecoService.updateEndereco(id, EnderecoResponseDTO );
        return ResponseEntity.ok(updatedEndereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable("id")UUID id){
        this.enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
