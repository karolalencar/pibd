create table AgendamentoParaEmLocal(
    cnpj VARCHAR(11),
    efetuado_as TIMESTAMP,
    cep VARCHAR(8), 
    num INT,
    indice_trecho VARCHAR(255),
    num_passageiros INT,
    PRIMARY KEY (cnpj, efetuado_as, cep, num),
    FOREIGN KEY (cnpj, efetuado_as) REFERENCES Agendamento(cnpj, efetuado_as),
    FOREIGN KEY (cep, num) REFERENCES Local(cep, num)
);
