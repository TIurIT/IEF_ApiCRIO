package com.crio.api.repositories;

import com.crio.api.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnderecoRepositiry extends JpaRepository <Endereco, UUID> {

    //selecionar todos os Enderecos
    @Query("SELECT e FROM Endereco e")
    List<Endereco> findallEndereco();
    //selecionar Endereco pelo id
    @Query("SELECT e FROM Endereco e WHERE e.id = :id")
    Optional<Endereco> findByIdEndereco(UUID id);
    //salvar Endereco
    @Query("INSERT INTO Endereco(cidade, uf) VALUES(:cidade, :uf)")
    Endereco saveEndereco(String cidade, String uf);
    //    //update Endereco
//    @Query("UPDATE Endereco e SET e.cidade=:cidade, e.uf=:uf WHERE e.id=:id")
//    void update(UUID id, String cidade, String uf);
    //delete Endereco
    @Query("DELETE FROM Endereco e WHERE e.id=:id")
    void deleteByIdEndereco(UUID id);
    
}
