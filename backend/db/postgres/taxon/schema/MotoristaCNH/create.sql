create table MotoristaCNH(
    cpf varchar(15),
    num_registro int,
    categoria NOT NULL,
    vencimento_em TIMESTAMP NOT NULL,
    emitida_em TIMESTAMP NOT NULL, 
    PRIMARY key (cpf, num_registro),
    FOREIGN key (cpf) REFERENCES Motorista
);
