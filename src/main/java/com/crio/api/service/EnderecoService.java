package com.crio.api.service;

import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.endereco.EnderecoRequestDTO;
import com.crio.api.domain.endereco.EnderecoResponseDTO;
import com.crio.api.repositories.EnderecoRepositiry;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EnderecoService {
   
    @Autowired
    private EnderecoRepositiry enderecoRepositiry;

    public Endereco createEndereco(EnderecoRequestDTO data){
        Endereco newEndereco = new Endereco();
        newEndereco.setCidade(data.cidade());
        newEndereco.setUf(data.uf());
        enderecoRepositiry.save(newEndereco);

        return newEndereco;
    }

    public List<Endereco> getAllEnderecos(){
        return enderecoRepositiry.findAll();
    }

    public Endereco getEnderecoById(UUID id) {
        return  enderecoRepositiry.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado."));
    }

    public Endereco updateEndereco(UUID id, EnderecoResponseDTO EnderecoResponseDTO) {
        Endereco updatedEndereco = getEnderecoById(id);
        updatedEndereco.setCidade(EnderecoResponseDTO.cidade());
        updatedEndereco.setUf(EnderecoResponseDTO.uf());

        return enderecoRepositiry.save(updatedEndereco);
    }

    public void deleteEndereco(UUID id){
        Endereco Endereco = getEnderecoById(id);
        enderecoRepositiry.delete(Endereco);
    }

    public List<Endereco> findByCity(String cidade){
        return enderecoRepositiry.findByCity(cidade);
    }

    public List<Endereco> findByUf(String uf){
        return enderecoRepositiry.findByUf(uf);
    }

}
