CREATE TABLE Passageiro(
	cpf CHAR(11),
	PRIMARY KEY (cpf),
	FOREIGN KEY (cpf) REFERENCES Fisica(cpf)
);
