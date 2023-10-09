package com.agreenfood.agreenfood.repository;

import com.agreenfood.agreenfood.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    List<Produtos> findAllByNomeProdutoContainingIgnoreCase(@Param("nome") String nome_produto);
}
