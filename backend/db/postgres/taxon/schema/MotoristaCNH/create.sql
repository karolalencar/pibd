create table MotoristaCNH(
    cpf varchar(15),
    num_registro int,
    categoria VARCHAR(2) NOT NULL CHECK IN ('A', 'B', 'C', 'D', 'E', 'AB', 'AC', 'AD', 'AE'),
    vencimento_em TIMESTAMP NOT NULL,
    emitida_em TIMESTAMP NOT NULL, 
    PRIMARY key (cpf, num_registro),
    FOREIGN key (cpf) REFERENCES Motorista
);
