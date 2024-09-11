package com.crio.api.service;

import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.endereco.EnderecoRequestDTO;
import com.crio.api.domain.endereco.EnderecoResponseDTO;
import com.crio.api.repositories.EnderecoRepositiry;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.UUID;

public class EnderecoService {
   
    @Autowired
    private EnderecoRepositiry EnderecoRepository;

    public Endereco createEndereco(EnderecoRequestDTO data){
        Endereco newEndereco = new Endereco();
        newEndereco.setCidade(data.cidade());
        newEndereco.setUf(data.uf());
        EnderecoRepository.save(newEndereco);

        return newEndereco;
    }

    public List<Endereco> getAllEnderecos(){
        return EnderecoRepository.findAll();
    }

    public Endereco getEnderecoById(UUID id) {
        return  EnderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado."));
    }

    public Endereco updateEndereco(UUID id, EnderecoResponseDTO EnderecoResponseDTO) {
        Endereco updatedEndereco = getEnderecoById(id);
        updatedEndereco.setCidade(EnderecoResponseDTO.cidade());
        updatedEndereco.setUf(EnderecoResponseDTO.uf());

        return EnderecoRepository.save(updatedEndereco);
    }

    public void deleteEndereco(UUID id){
        Endereco Endereco = getEnderecoById(id);
        EnderecoRepository.delete(Endereco);
    }
}
