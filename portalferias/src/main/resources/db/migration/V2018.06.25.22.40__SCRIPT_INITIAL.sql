
create table tb_Cargo(
cod_Cargo SERIAL not null primary key,
des_Cargo varchar(60) not null
);

create table tb_Evento(
cod_Evento SERIAL not null primary key,
ds_Evento varchar(60) not null,
tipoEvento varchar(1) not null
);


create table tb_Funcionario(
cod_Funcionario SERIAL not null primary key,
nome varchar(60) not null,
cpf varchar(11) not null,
Rg varchar(10) not null , 
dt_Nascimento date not null, 
dt_Admissao date not null,
cod_Cargo int not null,
foreign key (cod_Cargo) references tb_Cargo (cod_Cargo)
);


create table  tb_Ferias(
cod_Ferias SERIAL not null primary key,
dt_InicioAquisicao date not null, 
dt_FinalAquisicao date not null,
cod_Funcionario int not null,
foreign key (cod_Funcionario) references tb_Funcionario (cod_Funcionario)
);


create table tb_GozoFerias(
cod_GozoFerias SERIAL not null primary key,
dt_InicioGozo date not null,
dt_FinalGozo date not null, 
dt_PagamentoFerias date null,
cod_Ferias int not null,
foreign key (cod_Ferias) references tb_Ferias (cod_Ferias)
);


create table tb_FuncionarioEvento(
cod_FuncionarioEvento SERIAL not null primary key,
dt_InicioEvento date not null,
dt_FinalEvento date not null,
des_observacao varchar(400),
cod_Funcionario int not null,
cod_Evento int not null,
foreign key (cod_Funcionario) references tb_Funcionario (cod_Funcionario),
foreign key (cod_Evento) references tb_evento (cod_Evento)
);
