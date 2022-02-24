CREATE TABLE MotoristaAcessaVeiculo(
	cpf CHAR(11),
	chassi CHAR(17),
	PRIMARY KEY(cpf, chassi),
	FOREIGN KEY(cpf) REFERENCES Motorista(cpf),
	FOREIGN KEY(chassi) REFERENCES Veiculo(chassi)
);
