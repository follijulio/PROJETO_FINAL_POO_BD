create database biblioteca;
use biblioteca;

create table autor(
id integer not null primary key,
pseudonimo varchar(200),
nacionalidade varchar(200),
data_nascimento varchar(200)
);


create table livro(
id integer not null auto_increment primary key,
titulo varchar(200),
situacao boolean,
lancamento varchar(100),
editora varchar(200),
genero varchar(200),
numero_paginas integer,
idioma_original varchar(200),
idioma_atual varchar(200),
id_do_autor integer,
id_do_funcionario integer,
foreign key (id_do_autor) references autor(id),
FOREIGN KEY (id_do_funcionario) references Funcionario(id)
);

create table funcionario(
id integer not null auto_increment primary key,
nome varchar(200),
codigo varchar(8),
senha varchar(4),
salario decimal(10,2)
);
