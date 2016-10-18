--Tema

-- exibir empregados admitidos entre datas do where e meses trabalhados ate o ano 2000(datadiff)
select NomeEmpregado, 
		DataAdmissao, 
		datediff(MONTH, DataAdmissao, convert(datetime, '31/12/2000', 103)) as meses_Trabalhados
from Empregado 
where DataAdmissao between convert(datetime,'01/05/1980',103)
					  and convert(datetime, '20/01/1982', 103);

-- selecionar cargo com maior quantidade de funcionarios
select top(1) WITH TIES Cargo, 
	   count(NomeEmpregado) as qtd_funcionarios 
from Empregado
group by Cargo
order by qtd_funcionarios desc;

-- quantidade de cidades por UF
select UF, count(Nome) as qtd_cidades from cidade
group by UF
order by qtd_cidades desc;


-- contar registros duplicados
select Nome, UF, COUNT(1) as qtd_registros 
from Cidade
group by Nome, UF
having count(1) > 1;


-- buscar ID(+1 pega o proximo Id a ser usado)
select Max(IDAssociado) + 1 as Proximo_ID from Associado;


-- calcular descontar imposto de renda
select NomeEmpregado, Salario, salario * 0.15 as Desconto from Empregado
where salario between 1164.00 and 2326.00
union all
select NomeEmpregado, Salario, salario * 0.275 as Desconto from Empregado
where Salario > 2326.00
order by Salario;

-- versão correta exercicio
select NomeEmpregado, Salario,
case when Salario <=1164 then 0
	 when salario <= 2326 then 15
	 else 27.5
	 end perc_IR
	 from Empregado;


-- Listar nome empregado, nome gerente, nome departamento
select e.NomeEmpregado as nomeEmpregado,
	   g.NomeEmpregado as NomeGerente,
	   d.NomeDepartamento as DepartamentoEmpregado,
	   f.NomeDepartamento as DepartamentoGerente
from Empregado e
INNER JOIN Empregado g on e.IDGerente = g.IDEmpregado
INNER JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento
INNER JOIN Departamento f on e.IDGerente = g.IDEmpregado and 
		  g.IDDepartamento = f.IDDepartamento;

-----------------------------------------------------------------

-- faz copia tabela Empregado e altera salario
select * into copia_Empregado
	from Empregado;

update copia_Empregado
set Salario = Salario + (Salario * 0.145)
from copia_Empregado e
inner join Departamento d on e.IDDepartamento = d.IDDepartamento
where d.localizacao = 'Sao Paulo';

-- OUTRA MANEIRA

-- update copia_Empregado
--	set Salario = salario * 1.145
--	where exists(select 1 
--				 from departamento 
--				 where departamento.IDDepartamento = Empregado.IDDepartamento
--				 and Departamento.localizacao = 'Sao Paulo' )


-- usei somente para conferir resultado
select Salario from copia_Empregado e
inner join Departamento d on e.IDDepartamento = d.IDDepartamento
where d.localizacao = 'Sao Paulo';

select e.Salario, d.IDDepartamento from Empregado e
inner join Departamento d on e.IDDepartamento = d.IDDepartamento
where d.localizacao = 'Sao Paulo';
----------------------------------------------------------------

-- lista diferenca na alteracao do salario
select  sum(e.Salario) as salario_Empregados, 
		sum(c.Salario) as Salario_Empregado_Alterado,
		sum(c.Salario) - sum(e.salario) as diferença
from Empregado e, copia_Empregado c;


-- listar departamento do empregado com maior salario
select top 1 d.NomeDepartamento, max(e.Salario) as maior_Salario 
from Empregado e
inner join Departamento d on e.IDDepartamento = d.IDDepartamento
group by NomeDepartamento
order by maior_salario desc;

-- melhor trazer informaçoes com exists