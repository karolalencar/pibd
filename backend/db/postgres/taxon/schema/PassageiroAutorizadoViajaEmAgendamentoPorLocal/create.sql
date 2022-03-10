CREATE TABLE PassageiroAutorizadoViajaEmAgendamentoPorLocal(
	passageiro_autorizado_cpf CHAR(11),
	passageiro_autorizado_cnpj CHAR(14),
	agendamento_id INT,
	cep CHAR(8),
	num INT,
	PRIMARY KEY (passageiro_autorizado_cpf, passageiro_autorizado_cnpj, agendamento_id),
	FOREIGN KEY (passageiro_autorizado_cpf, passageiro_autorizado_cnpj) REFERENCES PassageiroAutorizado(cpf, cnpj),
	FOREIGN KEY (agendamento_id) REFERENCES Agendamento(id),
	FOREIGN KEY (cep, num) REFERENCES Local(cep, num)
);
