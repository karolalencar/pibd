create table Agendamento(
    cnpj VARCHAR(11),
    cep VARCHAR(8), 
    num INT,
    efetuado_as TIMESTAMP,
    PRIMARY KEY(cnpj, cep, num, efetuado_as),
    FOREIGN KEY(cnpj) REFERENCES Conveniada(cnpj),
    FOREIGN KEY(cep, num) REFERENCES Local(cep, num)
);
