-- TABLE
CREATE TABLE pessoa (pessoa_id  integer, cpf varchar(255) not null, data_de_nascimento date not null, email varchar(255) not null, idade integer not null, nome varchar(255) not null, primary key (pessoa_id));
CREATE TABLE produto (produto_id  integer, nome varchar(255) not null, preco double precision not null, quantidade integer not null, status boolean not null, primary key (produto_id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
