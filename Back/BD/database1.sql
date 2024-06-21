CREATE DATABASE lenguaje;
USE lenguaje;

DROP TABLE IF EXISTS vocabulary;
DROP TABLE IF EXISTS vocabulario;
DROP TABLE IF EXISTS tabla;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS tabla_usuario;

DROP DATABASE IF EXISTS lenguaje;

CREATE TABLE vocabulary(
	id_verb INT NOT NULL AUTO_INCREMENT,
    id_table INT NOT NULL,
    infinitive VARCHAR(30) NOT NULL,
    simple_past VARCHAR(30) NOT NULL,
    past_participle VARCHAR(30),
    gerund VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_verb)
);

CREATE TABLE vocabulario(
	id_verbo INT NOT NULL AUTO_INCREMENT,
    id_tabla INT NOT NULL,
    infinitivo VARCHAR(30) NOT NULL,
    pasado_simple VARCHAR(30) NOT NULL,
    pasado_participio VARCHAR(30),
    gerundio VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_verbo)
);

CREATE TABLE tabla(
	id_tabla INT NOT NULL AUTO_INCREMENT,
    color VARCHAR(30) NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    id_tabla_vocabulario INT NOT NULL,
    id_table_vocabulary INT NOT NULL,
    PRIMARY KEY (id_tabla),
    FOREIGN KEY (id_tabla_vocabulario) REFERENCES vocabulario(id_verbo),
    FOREIGN KEY (id_table_vocabulary) REFERENCES vocabulary(id_verb)
);

CREATE TABLE usuario(
	id_usuario INT NOT NULL AUTO_INCREMENT,
    contrasena VARCHAR(30) NOT NULL,
    imagen VARCHAR(30) NOT NULL,
    cellphone VARCHAR(30) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    PRIMARY KEY (id_usuario)
);

CREATE TABLE tabla_usuario(
	id_tabla_usuario INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    id_tabla INT,
    id_usuario INT,
    PRIMARY KEY (id_tabla_usuario),
    FOREIGN KEY (id_tabla) REFERENCES tabla(id_tabla),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

SELECT * FROM vocabulary;
SELECT * FROM vocabulario;
SELECT * FROM tabla;
SELECT * FROM usuario;
SELECT * FROM tabla_usuario;

UPDATE vocabulary SET infinitive = 'to burn' WHERE id_vocabulary = 1;
UPDATE vocabulary SET id_tabla = 3 WHERE id_vocabulary = 1;

INSERT INTO usuario (contrasena, imagen, cellphone, nombre) VALUES ('Marm7913*', '../Imagenes/Yo.png', '2212707279', 'Miguel Arturo');



