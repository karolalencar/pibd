create table Convenio(
    cnpj varchar(15),
    inicio_em TIMESTAMP,
    termino_em TIMESTAMP NOT NULL,
    PRIMARY key (cnpj, inicio_em),
    FOREIGN key (cnpj) REFERENCES Conveniada(cnpj)
);
