DROP TABLE categorias;
DROP TABLE situacoes;
DROP TABLE tipo_despesas;
DROP TABLE lancamentos;

CREATE TABLE categorias (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            descricao VARCHAR(255) NOT NULL
)  ENGINE=INNODB;

CREATE TABLE situacoes (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           nome VARCHAR(255) NOT NULL,
                           descricao VARCHAR(255) NOT NULL
)  ENGINE=INNODB;


CREATE TABLE tipo_despesas (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               nome VARCHAR(255) NOT NULL,
                               descricao VARCHAR(255) NOT NULL
)  ENGINE=INNODB;


CREATE TABLE lancamentos (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             nome VARCHAR(255) NOT NULL,
                             descricao VARCHAR(255) NOT NULL,
                             valor decimal(15,2) NOT NULL,
                             data date NOT NULL,
                             situacao_fk INT NOT NULL,
                             categoria_fk INT NOT NULL,
                             tipo_despesa_fk INT NOT NULL,
                             FOREIGN KEY (situacao_fk) REFERENCES situacoes(id),
                             FOREIGN KEY (categoria_fk) REFERENCES categorias(id),
                             FOREIGN KEY (tipo_despesa_fk) REFERENCES tipo_despesas(id)
)  ENGINE=INNODB;

select * from situacoes;
insert into situacoes (nome, descricao) values ('PAGO', 'Pagamento efetivado');
insert into situacoes (nome, descricao) values ('PENDENTE', 'Pendente de pagamento');

select * from categorias;
insert into categorias (nome, descricao) values ('Saúde', 'Despesas com Saúde');
insert into categorias (nome, descricao) values ('Lazer', 'Despesas com Lazer');
insert into categorias (nome, descricao) values ('Salário', 'Salário empresa CLT');

select * from tipo_despesas;
insert into tipo_despesas (nome, descricao) values ('Despesa', 'Despesas');
insert into tipo_despesas (nome, descricao) values ('Receita', 'Receitas');

select * from lancamentos;

insert into lancamentos (nome, descricao, valor, data, situacao_fk, categoria_fk, tipo_despesa_fk) values ('cinema', 'cinemark', 11.11, now(), 1, 2,1);
insert into lancamentos (nome, descricao, valor, data, situacao_fk, categoria_fk, tipo_despesa_fk) values ('Plano de saúde', 'Plano Sul América Familiar', 1100.11, now(), 1, 1,1);
insert into lancamentos (nome, descricao, valor, data, situacao_fk, categoria_fk, tipo_despesa_fk) values ('Salário do Mês', 'Salário do Mês CLT', 11000.11, now(), 2, 3,2);

select * from lancamentos

select l.nome nome, l.descricao descricao, l.valor valor, l.data data_lancamento, c.nome categoria, s.nome situacao, td.nome tipo_despesa from lancamentos l
                                                                                                                                                   inner join categorias c on l.categoria_fk = c.id
                                                                                                                                                   inner join situacoes s on l.situacao_fk = s.id
                                                                                                                                                   inner join tipo_despesas td on l.tipo_despesa_fk = td.id;


--- select * from categorias where upper(nome) = upper(:nome) or upper(descricao) = upper(:descricao)
--- select * from lancamentos where nome = 'cinema' or descricao = 'Plano Sul América Familiar' or valor > 10000 or data > '2022-09-21'
