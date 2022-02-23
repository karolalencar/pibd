CREATE TABLE Convenio(
	cnpj_conveniada CHAR(14),
    convenio VARCHAR(30) NOT NULL,
	PRIMARY KEY(cnpj_conveniada, convenio),
	FOREIGN KEY (cnpj_conveniada) REFERENCES Conveniada(cnpj)
);