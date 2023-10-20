CREATE DATABASE db_ecommerce_as;

use db_ecommerce_as;

CREATE TABLE tb_usuario_ecommerce (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome_completo VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    doc_identificador VARCHAR(255) NOT NULL UNIQUE,
    cep INT NOT NULL,
    num_residencial VARCHAR(255) NOT NULL,
    complemento VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE tb_categorias_ecommerce (
    id BIGINT NOT NULL AUTO_INCREMENT,
    tipo VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

CREATE TABLE tb_produtos_ecommerce (
    id BIGINT NOT NULL AUTO_INCREMENT  primary key,
    nome_produto VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(8 , 2 ) NOT NULL,
    quantidade INT NOT NULL,
    foto VARCHAR(255) NOT NULL,
    vendedor VARCHAR(255) NOT NULL,
    categoria_id BIGINT NOT NULL UNIQUE,
    usuario_id BIGINT NOT NULL UNIQUE,
    foreign key (categoria_id) references tb_categorias_ecommerce(id),
    foreign key (usuario_id) references tb_usuario_ecommerce(id)
);

