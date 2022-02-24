CREATE TABLE PassageiroAutorizadoViajaEmAgendamentoPorLocal(
	passageiro_autorizado_cpf CHAR(11),
	passageiro_autorizado_cnpj CHAR(14),
	agendamento_cnpj CHAR(14),
	agendamento_efetuado_as TIMESTAMP,
	cep CHAR(8),
	num INT,
	PRIMARY KEY (passageiro_autorizado_cpf, passageiro_autorizado_cnpj, agendamento_cnpj, agendamento_efetuado_as),
	FOREIGN KEY (passageiro_autorizado_cpf, passageiro_autorizado_cnpj) REFERENCES PassageiroAutorizado(cpf, cnpj),
	FOREIGN KEY (agendamento_cnpj, agendamento_efetuado_as) REFERENCES Agendamento(cnpj, efetuado_as),
	FOREIGN KEY (cep, num) REFERENCES Local(cep, num)
);
