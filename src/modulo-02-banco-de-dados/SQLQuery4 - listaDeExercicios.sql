
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

select cli.Nome, pei.IDPedido, pe.DataEntrega, pe.ValorPedido, pei.Quantidade from Produto p
inner join ProdutoMaterial pm on p.IDProduto = pm.IDProduto
inner join Material m on m.IDMaterial = pm.IDMaterial
inner join PedidoItem pei on pei.IDProduto = p.IDProduto
inner join Pedido pe on pe.IDPedido = pei.IDPedido
inner join Cliente cli on pe.IDCliente = cli.IDCliente
where (m.IDMaterial = 14650 or m.IDMaterial = 15703 or m.IDMaterial = 15836 or
m.IDMaterial = 16003 or m.IDMaterial = 16604 or m.IDMaterial = 17226) and
(pe.DataEntrega between CONVERT(datetime, '01/10/2016', 103) and 
					   CONVERT(datetime, '30/10/2016', 103))
order by pei.IDPedido;

-- 08
select p.nome from Produto p
left join ProdutoMaterial pm on pm.IDProduto = p.IDProduto
where pm.IDMaterial is null;

-- 09
select top(1) Substring(Ltrim(Rtrim(Nome)), 1, 
Case When (Charindex(' ', Ltrim(Rtrim(Nome))) - 1) < 0 Then Len(Ltrim(Rtrim(Nome))) 
Else Charindex(' ', Ltrim(Rtrim(Nome))) - 1 End) as Nome, count(1) as Mais_popular
from Cliente
group by Substring(Ltrim(Rtrim(Nome)), 1, 
Case When (Charindex(' ', Ltrim(Rtrim(Nome))) - 1) < 0 Then Len(Ltrim(Rtrim(Nome))) 
Else Charindex(' ', Ltrim(Rtrim(Nome))) - 1 End)
order by Mais_popular desc;

-- 10

begin transaction t1

update Produto
set Situacao = 'F'
from Produto p
inner join ProdutoMaterial pm on pm.IDProduto = p.IDProduto
where (pm.IDMaterial = 14650 or pm.IDMaterial = 15703 or pm.IDMaterial = 15836 or
pm.IDMaterial = 16003 or pm.IDMaterial = 16604 or pm.IDMaterial = 17226);

begin transaction t2
update Produto			-- provavelmente ta errado :p
set Situacao = 'Q'
from Produto p
inner join PedidoItem pei on pei.IDProduto = p.IDProduto
inner join Pedido pe on pe.IDPedido = pei.IDPedido
where pe.DataPedido < CONVERT(datetime, '17/08/2016', 103);

RollBack t2

begin transaction t3
update Produto
set Situacao = 'A'
from Produto
where Situacao != 'F' and Situacao != 'Q';
RollBack


------------------------------------------------ verificação dados

select p.situacao from PedidoItem pei
inner join Produto p on p.IDProduto = pei.IDProduto
inner join ProdutoMaterial pm on pm.IDProduto = pei.IDProduto
where (pm.IDMaterial = 14650 or pm.IDMaterial = 15703 or pm.IDMaterial = 15836 or
pm.IDMaterial = 16003 or pm.IDMaterial = 16604 or pm.IDMaterial = 17226);


select p.Nome, p.Situacao, pe.DataPedido, GETDATE() as Data_Atual
from Produto p
inner join PedidoItem pei on pei.IDProduto = p.IDProduto
inner join Pedido pe on pe.IDPedido = pei.IDPedido
where pe.DataPedido < CONVERT(datetime, '17/08/2016', 103);

select * from Produto where Situacao = 'A'
