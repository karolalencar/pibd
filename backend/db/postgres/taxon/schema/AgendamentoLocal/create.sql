create table AgendamentoParaLocal(
    cnpj VARCHAR(11),
    efetuado_as DATETIME,
    cep VARCHAR(8), 
    num INT,
    indice_trecho VARCHAR(255),
    num_passageiros INT
    PRIMARY KEY (cnpj, efetuado_às, cep, num),
    FOREIGN KEY (cnpj, efetuado_as) REFERENCES AGENDAMENTO(cnpj, efetuado_as),
    FOREIGN KEY (cep, num) REFERENCES LOCAL(cep, num)
);