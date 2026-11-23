CREATE DATABASE IF NOT EXISTS jogos_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE jogos_db;

CREATE TABLE IF NOT EXISTS jogador (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    nome        VARCHAR(100) NOT NULL,
    email       VARCHAR(120) NOT NULL UNIQUE,
    cep         CHAR(8)      NOT NULL,
    logradouro  VARCHAR(150),
    bairro      VARCHAR(100),
    cidade      VARCHAR(100),
    uf          CHAR(2)
);

CREATE TABLE IF NOT EXISTS partida (
    id            INT AUTO_INCREMENT PRIMARY KEY,
    jogador_id    INT          NOT NULL,
    jogo          VARCHAR(100) NOT NULL,
    pontuacao     INT          NOT NULL,
    resultado     VARCHAR(10)  NOT NULL,
    data_partida  DATE         NOT NULL,
    CONSTRAINT fk_partida_jogador
        FOREIGN KEY (jogador_id) REFERENCES jogador (id)
        ON DELETE CASCADE
);