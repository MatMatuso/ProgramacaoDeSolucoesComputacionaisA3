create database ProgramaProjeto;
use ProgramaProjeto;
create table Usuarios(
 nome text,
 cpf text,
 email text,
 cargo text,
 login text,
 senha text,
 perfil text
);
insert into Usuarios(nome,cpf,email,cargo,login,senha,perfil) values (
 "Mattheus",
 "45693",
 "qualquer@qualquer",
 "auxiliar",
 "matuso",
 "12345",
 "Administrador"
);
select * from Usuarios;
drop table Usuarios;
create table Projetos(
 nome text,
 criador text,
 participante text,
 datadecriacao timestamp,
 ativo boolean
);
create table Tarefas(
 Prazo text,
 Responsavel text,
 meta text
);