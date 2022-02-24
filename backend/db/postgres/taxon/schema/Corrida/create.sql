CREATE TABLE Corrida(
	cpf CHAR(11),
	chassi CHAR(17),
	inicia_as TIMESTAMP,
	termina_as TIMESTAMP,
	valor REAL,
	inicia_em VARCHAR(50),
	termina_em VARCHAR(50),
	agendamento_cnpj CHAR(14),
	agendamento_efetuado_as TIMESTAMP,
	fatura_cnpj CHAR(14),
	fatura_mes VARCHAR(10),
	fatura_ano CHAR(4),
	PRIMARY KEY(cpf, chassi, inicia_as),
	FOREIGN KEY(cpf, chassi) REFERENCES MotoristaHabilitado(cpf, chassi),
	FOREIGN KEY(agendamento_cnpj, agendamento_efetuado_as) REFERENCES Agendamento(cnpj, efetuado_as),
	FOREIGN KEY(fatura_cnpj, fatura_mes, fatura_ano) REFERENCES Fatura(cnpj, mes, ano)
);
