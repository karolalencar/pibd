create table inicio_previsto_as(
    cep VARCHAR(8), 
    num INT,
    inicio_previsto_as DATETIME,
    PRIMARY key (cep, num, inicio_previsto_as),
    FOREIGN key (cep, num) REFERENCES AGENDAMENTO(cep, num)
);
