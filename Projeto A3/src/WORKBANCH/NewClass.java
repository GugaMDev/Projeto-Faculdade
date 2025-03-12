/*drop database db_pessoas;

create database db_pessoas;
drop table tb_usuario;
drop table tb_empresa;
drop table tb_agendamento;

use db_pessoas;
create table tb_pessoa ( codigo int auto_increment primary key,
nome varchar (200),
fone varchar(200),
email varchar(200));

select * from tb_pessoa;
select * from tb_usuario;

insert into tb_pessoa (codigo, nome, fone, email)
values (1,"Guga", "11994122342", "guga@gmail.com");


create table tb_usuario ( codigo int auto_increment primary key,
nome varchar (200),
senha varchar(200),
email varchar(200),
cpf varchar(14),
logradouro varchar(200),
complementos varchar (200),
bairro varchar (200),
uf varchar (200),
cidade varchar (200),
cep varchar (200));


create table tb_empresa ( codigo int auto_increment primary key,
razaosocial varchar (200),
senha varchar(200),
email varchar(200),
cnpj varchar(18),
logradouro varchar(200),
complementos varchar (200),
bairro varchar (200),
uf varchar (200),
cidade varchar (200),
cep varchar (200));

create table tb_agendamento ( codigo int auto_increment primary key,
objeto varchar (200),
kg varchar(200),
endereco varchar(200),
horario varchar(5),
obs varchar(200),
dia varchar (2),
mes varchar (2),
ano varchar (4));




select * from tb_usuario;	
select * from tb_empresa;	
select * from tb_agendamento;
*/