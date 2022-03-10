create table Agendamento(
    id SERIAL PRIMARY KEY,
    cnpj VARCHAR(14),
    efetuado_as TIMESTAMP,
    UNIQUE(cnpj, efetuado_as),
    FOREIGN KEY(cnpj) REFERENCES Conveniada(cnpj) 
);
