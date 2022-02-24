CREATE TABLE ConveniadaAutorizaPassageiro(
	cnpj CHAR(14),
	cpf CHAR(11),
	status VARCHAR(20),
	cargo VARCHAR(20),
	PRIMARY KEY (cnpj, cpf),
	FOREIGN KEY (cnpj) REFERENCES Conveniada(cnpj),
	FOREIGN KEY (cpf) REFERENCES Passageiro(cpf)
);
