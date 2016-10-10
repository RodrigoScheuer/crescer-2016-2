create table Carro (
        placa           varchar(7) ,
        cor             varchar(20),
        marca           varchar(30),
        modelo          varchar(30),
        proprietario    varchar(150),
        email           varchar(100),
        telefone        varchar(100)
    );

	alter table Carro alter column placa varchar(8);

	insert into Carro 
      (placa, cor, marca, modelo, proprietario, email, telefone) 
   values
      ('ABC-3401', 'branco', 'fiat', 'palio', 'carlos da silva', 
	  'carlos.silva@company.com', '9987-0102');

	  select * from Carro;

insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('ABC-3401', 'branco', 'fiat', 'palio', 'carlos da silva', 'carlos.silva@company.com', '9987-0102');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('ITR-1304', 'preto', 'citroen', 'C4', 'maria ribeiro', 'maria.ribeiro@company.com', '9764-1325');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('IAB-0101', 'preto', 'honda', 'civic', 'julia de souza', 'julia.souza@company.com', '9660-0669');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('MMA-9876', 'prata', 'fiat', 'siena', 'antonio silveira', 'antonio.silveira@company.com', '9495-2597');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('JIR-4576', 'branco', 'volkswagem', 'gol', 'pedro paulo de almeida', 'pedro.almeida@company.com', '8446-1332');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('POT-0660', 'amarelo', 'chevrolet', 'monza', 'alfredo silveira da silva', 'alfredo.silva@company.com', '8669-0909');

Select * 
  From Carro 
 Where proprietario = 'julia de souza';

 insert into carro 
   (placa, cor, marca, modelo, proprietario, email, telefone) 
  values 
   ('IAB-0101', 'preto', 'honda', 'civic', 'augusta cavalcante', 'augusta.cavalcante@company.com', '8778-4556');

   insert into carro
     (placa, cor, marca, modelo, proprietario, email, telefone) 
   values
     ('IXT-7181', 'cinza', 'volkswagen', 'passat', 'julia de souza', 'julia.souza@company.com', '9660-0669');

Select modelo, marca, placa
  From Carro 
 Where marca = 'volkswagen';

 Create table Pais
    ( IDPais   int         not null,
      Nome     varchar(50) not null,
      Sigla    varchar(3),
         constraint PK_Pais primary key (IDPais)
    );

	insert into Pais(IDPais, nome, sigla)
	values(1, 'Brazil', 'BRA');

	select * from Pais;
