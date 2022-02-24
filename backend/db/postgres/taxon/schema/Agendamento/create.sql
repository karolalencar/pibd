create table Agendamento(
    cnpj VARCHAR(11),
    efetuado_as TIMESTAMP,
    PRIMARY KEY(cnpj, efetuado_as),
    FOREIGN KEY(cnpj) REFERENCES Conveniada(cnpj)
);
