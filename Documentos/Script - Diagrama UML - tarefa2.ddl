-- Gerado por Oracle SQL Developer Data Modeler 4.1.5.907
--   em:        2016-10-13 14:46:35 BRT
--   site:      SQL Server 2012
--   tipo:      SQL Server 2012




CREATE
  TABLE Projeto
  (
    IDProjeto              NUMERIC (28) NOT NULL IDENTITY NOT FOR REPLICATION ,
    Nome                   VARCHAR (50) NOT NULL ,
    IDEmpregadoResponsavel NUMERIC (28) NOT NULL ,
    DataInicio             DATE NOT NULL ,
    DataFimPrevisto        DATE NOT NULL ,
    DataFimReal            DATE NOT NULL ,
    Situacao               CHAR (1) NOT NULL ,
    ValorPrevisto          NUMERIC (18,2) NOT NULL ,
    ValorRealizado         NUMERIC (18,2) NOT NULL ,
    ValorFaturado          NUMERIC (18,2) NOT NULL
  )
  ON "default"
GO
ALTER TABLE Projeto ADD CONSTRAINT Projeto_PK PRIMARY KEY CLUSTERED (IDProjeto)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE Projeto_Empregado
  (
    IDEmpregadoProjeto      INTEGER NOT NULL ,
    IDProjeto               NUMERIC (28) NOT NULL ,
    IDEmpregado             NUMERIC (28) NOT NULL ,
    Percentual_Participacao NUMERIC (3,2) NOT NULL
  )
  ON "default"
GO
ALTER TABLE Projeto_Empregado ADD CONSTRAINT Projeto_Empregado_PK PRIMARY KEY
CLUSTERED (IDEmpregadoProjeto)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO
ALTER TABLE Projeto_Empregado ADD CONSTRAINT UK_ProjetoEmpregado UNIQUE
NONCLUSTERED (IDProjeto, IDEmpregado)
ON "default"
GO

CREATE
  TABLE empregado
  (
    IDEmpregado NUMERIC (28) NOT NULL IDENTITY NOT FOR REPLICATION ,
    Nome        VARCHAR (60) NOT NULL ,
    Situacao    CHAR (1) NOT NULL
  )
  ON "default"
GO
ALTER TABLE empregado ADD CONSTRAINT empregado_PK PRIMARY KEY CLUSTERED (
IDEmpregado)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

ALTER TABLE Projeto_Empregado
ADD CONSTRAINT FK_EmpregadoPojeto_Empregado FOREIGN KEY
(
IDEmpregado
)
REFERENCES empregado
(
IDEmpregado
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Projeto_Empregado
ADD CONSTRAINT FK_EmpregadoProjeto_Projeto FOREIGN KEY
(
IDProjeto
)
REFERENCES Projeto
(
IDProjeto
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Projeto
ADD CONSTRAINT FK_Projeto_Empregado FOREIGN KEY
(
IDEmpregadoResponsavel
)
REFERENCES empregado
(
IDEmpregado
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             0
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE DATABASE                          0
-- CREATE DEFAULT                           0
-- CREATE INDEX ON VIEW                     0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE ROLE                              0
-- CREATE RULE                              0
-- CREATE SCHEMA                            0
-- CREATE SEQUENCE                          0
-- CREATE PARTITION FUNCTION                0
-- CREATE PARTITION SCHEME                  0
-- 
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
