-- TABLE
CREATE TABLE aluno (id  integer, email varchar(255), matricula varchar(255), nascimento date, nome_completo varchar(255), primary key (id));
CREATE TABLE aluno_curso (curso_id bigint not null, aluno_id bigint not null);
CREATE TABLE curso (id  integer, nome varchar(255), sigla varchar(255), professor_id bigint, material_id bigint, material_curso_id bigint, primary key (id));
CREATE TABLE endereco (id  integer, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), aluno_id bigint, primary key (id));
CREATE TABLE material_curso (id  integer, url varchar(255), curso_id bigint, primary key (id));
CREATE TABLE professor (id  integer, email varchar(255), matricula varchar(255), nome_completo varchar(255), primary key (id));
CREATE TABLE telefone (id  integer, ddd varchar(255), numero varchar(255), aluno_id bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
