CREATE TABLE MotoristaCNH (
    cpf CHAR(11),
    cnh CHAR(11),
    PRIMARY KEY (cpf, cnh),
    FOREIGN KEY (cpf) REFERENCES Motorista (cpf)
);
