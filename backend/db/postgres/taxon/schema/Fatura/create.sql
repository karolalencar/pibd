CREATE TABLE Fatura(
	cnpj_conveniada CHAR(14),
    mes VARCHAR(3) NOT NULL,
    ano VARCHAR(6) NOT NULL,
	PRIMARY KEY(cnpj_conveniada, mes, ano),
	FOREIGN KEY (cnpj_conveniada) REFERENCES Conveniada(cnpj)
);