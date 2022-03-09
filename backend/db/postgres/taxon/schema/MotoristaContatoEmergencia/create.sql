create table MotoristaContEmergencia(
    cpf VARCHAR(15),
    ddd INT,
    num_telefone INT,
    nome VARCHAR(30) NOT NULL,
    parentesco VARCHAR(20),
    CEP varchar(9),
    num int,
    PRIMARY key (cpf, ddd, num_telefone),
    FOREIGN key (cpf) REFERENCES Motorista(cpf)
);
