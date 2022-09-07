CREATE TABLE categorias (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            descricao VARCHAR(255) NOT NULL
)  ENGINE=INNODB;

-- INSERIR
insert into categorias (nome, descricao) values ('JOGOS', 'Todo item relacionado a compra ou venda de jogos');
insert into categorias (nome, descricao) values ('FILMES', 'Todo item relacionado a compra ou venda de filmes');
insert into categorias (nome, descricao) values ('ESTUDO', 'Todo item relacionado a estudo');


-- CONSULTAR
select * from categorias;

-- DELETE
delete from categorias where id = 2
