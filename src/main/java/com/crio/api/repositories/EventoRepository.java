package com.crio.api.repositories;

import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository <Evento, UUID> {

    //selecionar todos os Eventos
    @Query("SELECT e FROM Evento e")
    List<Evento> findallEvento();

    //selecionar Evento pelo id
    @Query("SELECT e FROM Evento e WHERE e.id = :id")
    Optional<Evento> findByIdEvento(UUID id);

    //salvar Evento
    @Query("INSERT INTO Evento(titulo, descricao, inicio, fim, local, privado, linkEvento, comoChegar, linkForm, usuario_id, endereco_id) VALUES(:titulo, :descricao, :inicio, :fim, :local, :privado, :linkEvento, :comoChegar, :LinkForm, :usuario_id, :endereco_id)")
    Evento saveEvento(String titulo, String descricao, LocalDateTime inicio, LocalDateTime fim, String local, int privado, String linkEvento, String comoChegar, String linkForm, Usuario usuario_id, Endereco endereco_id);

    //    //update Evento
//    @Query("UPDATE Evento e SET e.titulo=:titulo, e.descricao=:descricao, e.inicio=:inicio, e.fim=:fim, e.local=:local, e.privado=:privado, e.linkEvento=:linkEvento, e.comoChegar=:comoChegar, e.linkForm=:linkForm, e.usuario_id=:usuario_id, e.endereco_id=endereco_id WHERE e.id=:id")
//    void update(UUID id, String nomeCompleto, String email, String senha, int tipo, LocalDateTime updatedAt);
    //delete Evento
    @Query("DELETE FROM Evento e WHERE e.id=:id")
    void deleteByIdEvento(UUID id);
    
}
