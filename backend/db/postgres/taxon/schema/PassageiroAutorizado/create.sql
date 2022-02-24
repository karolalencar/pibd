CREATE TABLE PassageiroAutorizado(
	cnpj CHAR(14),
	cpf CHAR(11),
	PRIMARY KEY(cnpj, cpf),
	FOREIGN KEY(cnpj) REFERENCES Conveniada(cnpj),
	FOREIGN KEY(cpf) REFERENCES Passageiro(cpf)
);
