CREATE TABLE MotoristaHabilitado(
	cpf CHAR(11),
	chassi CHAR(17),
	PRIMARY KEY(cpf, chassi),
	FOREIGN KEY(cpf, chassi) REFERENCES MotoristaAcessaVeiculo(cpf, chassi)
);
