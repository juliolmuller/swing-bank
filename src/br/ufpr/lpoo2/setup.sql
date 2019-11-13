
-- PostgreSQL

DROP TABLE IF EXISTS autor_livro;
DROP TABLE IF EXISTS autores;
DROP TABLE IF EXISTS livros;

CREATE TABLE autores(
    id SERIAL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    data_nasc DATE,
    documento CHAR(11),
    naturalidade VARCHAR(50)
);

CREATE TABLE livros(
    id SERIAL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    assunto VARCHAR(100),
    isbn CHAR(13),
    publicacao DATE
);

CREATE TABLE autor_livro(
    id_autor INT REFERENCES autores(id),
    id_livro INT REFERENCES livros(id)
);

INSERT INTO autores(nome, data_nasc, documento, naturalidade) VALUES
    ('Maquiavel', '1977-12-18', '11111111111', 'França'),
    ('Leonardo da Vinci', '1944-05-02', '22222222222', 'Itália'),
    ('Douglas Adams', '2000-01-01', '33333333333', 'Inglaterra'),
    ('C. S. Lewis', '1960-03-26', '44444444444', 'Estados Unidos'),
    ('J. R. R. Token', '1960-05-23', '55555555555', 'Estados Unidos');

insert into livros(nome, assunto, isbn, publicacao) VALUES
    ('O Príncipe', 'Política', '1234567891011', '1945-04-23'),
    ('As Crônicas de Nárnia', 'Infantil', '1112223334444', '1990-03-30'),
    ('O Senhor dos Anéis', 'Romance', '1112221112222', '1991-06-24'),
    ('O Hobbit', 'Romance', '1112222221111', '1992-05-12'),
    ('O Guia dos Mochileiros da Galáxia', 'Ficção', '3334445556666', '2001-09-11'),
    ('O Restaurante no Fim do Universo', 'Ficção', '3334444445555', '2002-10-13'),
    ('Adeus e Obrigado pelos Peixes', 'Ficção', '3334444444444', '2010-07-29'),
    ('Contos de Fadas', 'Infantil', '2223334448888', '2008-11-11');

INSERT INTO autor_livro VALUES
    (1, 1),
    (2, 1),
    (4, 2),
    (5, 3),
    (4, 4),
    (5, 4),
    (3, 5),
    (3, 6),
    (3, 7),
    (1, 7),
    (2, 8);

SELECT * FROM autores;
SELECT * FROM livros;
SELECT * FROM autor_livro;
SELECT a.nome AS "Autor", l.nome AS "Livro" FROM autores a
    INNER JOIN autor_livro al ON a.id = al.id_autor
    INNER JOIN livros l ON l.id = al.id_livro;
