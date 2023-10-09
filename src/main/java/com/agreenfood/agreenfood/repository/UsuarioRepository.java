package com.agreenfood.agreenfood.repository;


import com.agreenfood.agreenfood.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public List <Usuario> findByNomeCompletoContainingIgnoreCase(@Param("nomeCompleto") String nomeCompleto);
}
