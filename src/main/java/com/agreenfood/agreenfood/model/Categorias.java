package com.agreenfood.agreenfood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_categorias_ecommerce")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A atributo tipo é obrigatório")
    @Size(min = 2, max = 1000, message = " O atributo tipo deve conter no mínimo 2 caracteres e no máximo 1000 caracteres")
    private String tipo;


    @OneToMany(mappedBy = "categorias", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("categorias")
    private List<Produtos> produtos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }
}
