create table Agendamento(
    cnpj VARCHAR(14),
    efetuado_as TIMESTAMP,
    PRIMARY KEY(cnpj, efetuado_as),
    FOREIGN KEY(cnpj) REFERENCES Conveniada(cnpj) 
);
