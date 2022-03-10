create table AgendamentoParaEmLocal(
    agendamento_id INT,
    cep VARCHAR(8), 
    num INT,
    indice_trecho VARCHAR(255),
    num_passageiros INT,
    PRIMARY KEY (agendamento_id, cep, num),
    FOREIGN KEY (agendamento_id) REFERENCES Agendamento(id),
    FOREIGN KEY (cep, num) REFERENCES Local(cep, num)
);
