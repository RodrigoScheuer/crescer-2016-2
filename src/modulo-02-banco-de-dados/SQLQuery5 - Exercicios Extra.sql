-- Exercicios Extra

-- 01) Faça uma consulta que traga os clientes que mais compraram (frequência),
-- filtrando por estado e considerando apenas os últimos 3 meses.

select count(IDPedido) as qtd_pedido, cli.Nome, cid.UF from Pedido ped
inner join Cliente cli on cli.IDCliente = ped.IDCliente
inner join Cidade cid on cid.IDCidade = cli.IDCidade
where cli.IDCliente = ped.IDCliente and ped.DataPedido > (GETDATE() - 90) 
group by cli.Nome, cid.UF
having COUNT(IDPedido) > 1
order by qtd_pedido desc


-- 02) Faça uma consulta que liste as cidades duplicadas. 
-- Após identifique e liste os clientes que utilizam estas cidades 
-- (apenas as cidades duplicadas).
select  cid.Nome, cid.UF, count(1) as qtd_Repeticao from Cidade cid
group by cid.Nome, cid.UF
having count(cid.IDCidade) > 1		-- questão Incompleta (não sei fazer)


-- 03) Faça uma consulta que liste as cidades duplicadas, 
-- porém deve exibir apenas o primeiro registro inserido 
-- (menor ID entre as duplicadas).

select  min(cid.IDCidade) as Menor_IDCidade, cid.Nome, cid.UF, count(1) as qtd_Repeticao from Cidade cid
group by cid.Nome, cid.UF
having count(cid.IDCidade) > 1

select IDCidade, Nome from Cidade
where Nome = 'Acrelandia'

-- 04) Liste os 30 produtos que geraram mais lucro em 2016.
select top(30) Max(pe.ValorPedido * pei.Quantidade) as valor_Pedidos, p.IDProduto, p.Nome, pe.DataEntrega from Produto p
inner join PedidoItem pei on pei.IDProduto = p.IDProduto
inner join Pedido	  pe  on pe.IDPedido   = pei.IDPedido
where DataEntrega between convert(date, '01/01/2016', 103) and convert(date, '31/12/2016', 103)
group by p.IDProduto, p.Nome, pe.DataEntrega
order by valor_Pedidos desc




