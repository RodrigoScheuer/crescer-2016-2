
-- tarefa2

-- colaboradores com mais de um projeto

select Empregado, count(Projeto) as Numero_De_Projetos from Projeto
group by Empregado
having count(Projeto) > 1;

-- projetos que geraram lucro

select Projeto, ValorRealizado , ValorFaturado as faturamento from Projeto
group by Projeto, ValorRealizado, ValorFaturado
having valorFaturado > valorRealizado;

-- projetos que geraram prejuijo e percentual de prejuizo

select Projeto, ValorRealizado , ValorFaturado as faturamento,
 (((ValorFaturado - ValorRealizado) * 100)/ValorRealizado) as Porcentagem_de_Prejuizo
 from Projeto
group by Projeto, ValorRealizado, ValorFaturado
having valorFaturado <= valorRealizado;

-- listar distintos empregados e somente primeiro nome.

select count (Distinct Empregado) as Empregados_Distintos, Empregado,
Substring(Ltrim(Rtrim(Empregado)), 1, 
Case When (Charindex(' ', Ltrim(Rtrim(Empregado))) - 1) < 0 Then Len(Ltrim(Rtrim(Empregado))) 
Else Charindex(' ', Ltrim(Rtrim(Empregado))) - 1 End) as Nome
from Projeto
group by Empregado;




