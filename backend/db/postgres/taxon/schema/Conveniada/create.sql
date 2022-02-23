CREATE TABLE Conveniada(
	cnpj CHAR(14),
	PRIMARY KEY(cnpj),
	FOREIGN KEY (cnpj) REFERENCES Juridica(cnpj)
);
