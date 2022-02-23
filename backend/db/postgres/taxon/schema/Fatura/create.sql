CREATE TABLE Fatura(
	cnpj_conveniada CHAR(14) NOT NULL,
    mes VARCHAR(10) NOT NULL,
    ano CHAR(4) NOT NULL,
	PRIMARY KEY(cnpj_conveniada, mes, ano),
	FOREIGN KEY (cnpj_conveniada) REFERENCES Conveniada(cnpj)
);