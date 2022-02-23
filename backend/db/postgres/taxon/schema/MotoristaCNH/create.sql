CREATE TABLE MotoristaCNH (
    cpf VARCHAR(11),
    cnh VARCHAR(20),
    PRIMARY KEY (cpf, cnh),
    FOREIGN KEY (cpf) REFERENCES Motorista (cpf)
);