
insert into tb_Cargo values (1,'Desenvolvedor');
insert into tb_Cargo values (2,'Analista de Sistemas');
insert into tb_Cargo values (3,'Coordernador');
insert into tb_Cargo values (4,'Gerente');
insert into tb_Cargo values (5,'Analista de Qualidade');
insert into tb_Cargo values (6,'Assistente');

insert into tb_evento values(1,'Faltas', 'D');
insert into tb_evento values(2,'Folga', 'D');
insert into tb_evento values(3,'Recesso Coletivo', 'D');
insert into tb_evento values(4,'Falecimento de parentesco', 'C');


insert into tb_Funcionario values(1,'João Neto Borges', '11111111111','SP12345','1990-02-02','2011-03-13',1);
insert into tb_Funcionario values(2,'Maria Helena de Margalhães', '22222222222','MG12345','1978-05-23','2010-08-01',3);
insert into tb_Funcionario values(3,'Fracisco Machado', '33333333333','RJ12345','1975-07-02','2014-11-01',2);
insert into tb_Funcionario values(4,'Joaquim de Oliveria', '44444444444','ES12345','1980-07-15','2012-09-01',4);

insert into tb_Ferias values(1,'2011-03-13','2012-03-12',1);
insert into tb_Ferias values(2,'2012-03-13','2013-03-12',1);

insert into tb_GozoFerias values(1,'2012-04-01','2012-04-15','2013-04-15', 1);
insert into tb_GozoFerias values(2,'2012-04-16','2012-04-30','2013-04-15',1);
insert into tb_GozoFerias values(3,'2013-04-01','2013-04-10','2013-04-15',2);