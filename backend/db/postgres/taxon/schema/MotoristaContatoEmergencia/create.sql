CREATE Table MotoristaContatoEmergencia(
	cpf VARCHAR(11),
  contato_emergencia VARCHAR(13),
	PRIMARY KEY(cpf, inicio),
  FOREIGN KEY (cpf) REFERENCES Motorista(cpf)
);
