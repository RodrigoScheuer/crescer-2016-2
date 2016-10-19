-- Exercicios Extra

-- 01) Fa�a uma consulta que traga os clientes que mais compraram (frequ�ncia),
-- filtrando por estado e considerando apenas os �ltimos 3 meses.

select count(IDPedido) as qtd_pedido, cli.Nome, cid.UF from Pedido ped
inner join Cliente cli on cli.IDCliente = ped.IDCliente
inner join Cidade cid on cid.IDCidade = cli.IDCidade
where cli.IDCliente = ped.IDCliente and ped.DataPedido > (GETDATE() - 90)
group by cli.Nome, cid.UF
order by qtd_pedido desc


-- 02) Fa�a uma consulta que liste as cidades duplicadas. 
-- Ap�s identifique e liste os clientes que utilizam estas cidades 
-- (apenas as cidades duplicadas).

select  cid.Nome, cid.UF, count(1) as qtd_Repeticao from Cidade cid
group by cid.Nome, cid.UF
having count(cid.IDCidade) > 1
order by qtd_Repeticao desc

