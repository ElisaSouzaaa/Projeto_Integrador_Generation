package com.agreenfood.agreenfood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos_ecommerce")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome do produto é obrigatório!")
    @Size(min = 2, max = 255, message = "O atributo nome do produto deve conter no mínimo 2 caractéres, e no máximo 255")
    private String nome;

    @NotBlank(message = "O atributo descrição do produto é obrigatório!")
    @Size(min = 10, max = 255, message = "O atributo descrição do produto deve conter no mínimo 10 caractéres, e no máximo 255")
    private String descricao;

    @NotNull(message = "O atributo valor do produto é obrigatório!")
    @Column(precision = 10, scale = 2)
    @Positive(message = "O valor deve ser maior do que zero!")
    private BigDecimal valor;

    @NotBlank(message = "O atributo quantidade do produto é obrigatório")
    private Long quantidade;

    @Size(min = 5,max = 255)
    private String foto;

    @NotBlank(message = "O atributo foto do produto é obrigatório")
    private String vendedor;

    @ManyToOne
    @JsonIgnoreProperties("Categorias")
    private Categorias categorias;

    @ManyToOne
    @JsonIgnoreProperties("Produtos")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}