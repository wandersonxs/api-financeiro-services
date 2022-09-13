CREATE TABLE categorias (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            descricao VARCHAR(255) NOT NULL
)  ENGINE=INNODB;

-- INSERIR
insert into categorias (nome, descricao) values ('JOGOS', 'Todo item relacionado a compra ou venda de jogos');
insert into categorias (nome, descricao) values ('FILMES', 'Todo item relacionado a compra ou venda de filmes');
insert into categorias (nome, descricao) values ('ESTUDO', 'Todo item relacionado a estudo');
insert into categorias (nome, descricao) values ('TRABALHO', 'Todo item relacionado a trabalho profissional');
insert into categorias (nome, descricao) values ('ACADEMIA', 'Todo item relacionado a academia');
insert into categorias (nome, descricao) values ('FREELANCE', 'Projetos por fora');


-- CONSULTAR
select * from categorias;

-- DELETE
delete from categorias where id = 2

---


CREATE TABLE lancamentos (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             nome VARCHAR(255) NOT NULL,
                             descricao VARCHAR(255) NOT NULL
)  ENGINE=INNODB;

insert into lancamentos (nome, descricao) values ('Salario', 'Salário Empresa X');
insert into lancamentos (nome, descricao) values ('Escola', 'Despesa Escola');
insert into lancamentos (nome, descricao) values ('Projeto Freelance', 'Projeto Aula Freelance');

select * from lancamentos;



/*CREATE TABLE lancamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_despesa VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor decimal(15,2) NOT NULL,
    data date NOT NULL,
    situacao VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
)  ENGINE=INNODB;
*/
