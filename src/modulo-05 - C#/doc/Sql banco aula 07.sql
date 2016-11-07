
create table Movies
(id int primary key Identity,
 Title varchar(255) not null);

 create table Personagens
 (id int primary key identity,
 urlImagem varchar(300),
 nome varchar(120),
 idOrigem varchar(5),
 nascimento datetime,
 altura int,
 peso decimal(10,2),
 golpesEspeciais varchar(150),
 personagemOculto varchar(10)
 );

 insert into Personagens
 ( urlImagem, nome, idOrigem, nascimento, altura, peso, golpesEspeciais, personagemOculto)
 values
 ('https://upload.wikimedia.org/wikipedia/en/f/f4/Chun-Li_tatsunoko.png', 'Chun Li','JP', 01/03/1968, 170, 0, 'Spining Bird Kick, Kikouken.', 'false');

