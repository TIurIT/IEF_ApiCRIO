package com.crio.api.repositories;

import com.crio.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, UUID> {

    //selecionar todos os Usuarios
    @Query("SELECT u FROM Usuario u")
    List<Usuario> findallUsuario();
    //selecionar Usuario pelo id
    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    Optional<Usuario> findByIdUsuario(UUID id);
    //update Usuario
    @Query("UPDATE Usuario u SET u.nomeCompleto=:nomeCompleto, u.email=:email, u.senha=:senha, u.tipo=:tipo, u.updatedAt=:updatedAt WHERE u.id=:id")
    void update(UUID id, String nomeCompleto, String email, String senha, int tipo, LocalDateTime updatedAt);
    //delete Usuario
    @Query("DELETE FROM Usuario u WHERE u.id=:id")
    void deleteByIdUsuario(UUID id);
    //selecionar email
    @Query("SELECT u FROM Usuario u WHERE u.email=:email")
    List<Usuario> findByEmail(String email);
    //selecionar tipo
    @Query("SELECT u FROM Usuario u WHERE u.tipo=:tipo")
    List<Usuario> findByTipo(int tipo);
    //selecionar por criação
    @Query("SELECT u FROM Usuario u WHERE u.createdAt BETWEEN :createdAt AND :fim")
    List<Usuario> findByCreatedAtBetween(LocalDateTime createdAt, LocalDateTime fim);

}
