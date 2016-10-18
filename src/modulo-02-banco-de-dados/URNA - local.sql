CREATE TABLE MESARIO(
IDMesario integer      not null,
Nome      varchar2(30) not null,
constraint PK_MESARIO primary key(IDMesario));

CREATE SEQUENCE SEQ_MESARIO NOCACHE;

INSERT INTO MESARIO(IDMesario, Nome)
values (SEQ_MESARIO.NEXTVAL, 'Pedro de Souza');

select * from MESARIO;