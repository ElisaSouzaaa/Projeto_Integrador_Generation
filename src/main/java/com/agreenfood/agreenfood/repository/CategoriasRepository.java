package com.agreenfood.agreenfood.repository;

import com.agreenfood.agreenfood.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriasRepository extends JpaRepository<Categorias,Long> {

    public List<Categorias> findAllByTipoContainingIgnoreCase(@Param("tipo")String tipo);
}
