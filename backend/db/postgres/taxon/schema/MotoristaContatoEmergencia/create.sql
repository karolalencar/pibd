CREATE Table MotoristaContatoEmergencia(
	cpf VARCHAR(11),
	contato_emergencia VARCHAR(20),
	PRIMARY KEY(cpf, contato_emergencia),
	FOREIGN KEY (cpf) REFERENCES Motorista(cpf)
);
