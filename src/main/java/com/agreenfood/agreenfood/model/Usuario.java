package com.agreenfood.agreenfood.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome completo é obrigatório")
    @Size(min = 10, max = 100, message = "O atributo nome completo deve conter no mínimo 05 caractéres, e no máximo 100")
    private String nomeCompleto;

    @NotBlank(message = "O atributo email é obrigatório")
    @Size(min = 10, max = 1000, message = "O atributo email deve conter no mínimo 10 caractéres, e no máximo 1000")
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank(message = "O atributo senha é obrigatório")
    @Size(min = 8, max = 50, message = "O atributo senha deve conter no mínimo 8 caractéres, e no máximo 50")
    private String senha;

    @NotBlank(message = "O atributo identificador é obrigatório")
    @Size(min = 7, max = 20, message = "O atributo identificador deve conter no mínimo 7 caractéres, e no máximo 20")
    @Column(unique = true)
    private String docIdentificador;

    @NotNull(message = "O atributo CEP é obrigatório")
    //@Size(min = 8, max = 20, message = "O atributo identificador deve conter no mínimo 8 caractéres, e no máximo 20")
    private Long cep;

    @NotBlank(message = "O atributo número residencial é obrigatório")
    @Size(min = 1, max = 20, message = "O atributo número residencial deve conter no mínimo 1 caractéres, e no máximo 20")
    private String numeroResidencial;

    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "O atributo data nascimento é obrigatório")
    @Past
    private Date dataNascimento;

    private String complemento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Produtos> produtos;


    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocIdentificador() {
        return docIdentificador;
    }

    public void setDocIdentificador(String docIdentificador) {
        this.docIdentificador = docIdentificador;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getNumeroResidencial() {
        return numeroResidencial;
    }

    public void setNumeroResidencial(String numeroResidencial) {
        this.numeroResidencial = numeroResidencial;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
