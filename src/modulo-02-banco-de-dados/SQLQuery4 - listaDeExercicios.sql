
-- Lista de exercicios

-- 01
select count(*) as Total_Pedidos from Pedido
where DataEntrega between CONVERT(datetime, '01/09/2016', 103) and 
						  CONVERT(datetime, '30/09/2016', 103);

-- 02
select p.Nome from ProdutoMaterial pm
inner join Produto p on p.IDProduto = pm.IDProduto
inner join Material m on m.IDMaterial = pm.IDMaterial
where m.IDMaterial = '15836';

-- 03
select nome from Cliente
where Nome like '%LTDA%' or RazaoSocial like '%LTDA%';

-- 04
insert into Produto
(Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
values
('Galocha Maragato', GETDATE(), 35.67, 77.95, 'A');

select * from Produto where Nome = 'Galocha Maragato';

-- 05
select p.Nome 
from Produto p
left join PedidoItem pe on pe.IDProduto = p.IDProduto
where pe.IDProduto is null;

-- 06
-- maior numero de clientes
select top 1 count(cli.Nome) as qtd_Clientes, cid.UF as Estado from Cliente cli
inner join Cidade cid on cli.IDCidade = cid.IDCidade
group by UF
order by qtd_Clientes desc;

-- menor numero de clientes
select top 1 count(cli.Nome) as qtd_Clientes, cid.UF as Estado from Cliente cli
inner join Cidade cid on cli.IDCidade = cid.IDCidade
group by UF
order by qtd_Clientes asc;

-- 07
-- fazer esta questao em casa com tranquilidade

-- 08
select p.nome from Produto p
left join ProdutoMaterial pm on pm.IDProduto = p.IDProduto
where pm.IDMaterial is null;

-- 09
select Nome, count(1) as Mais_popular from cliente
group by Nome; -- terminar



