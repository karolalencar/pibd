CREATE TABLE Fatura(
	cnpj_conveniada CHAR(14),
    mes VARCHAR(10),
    ano CHAR(4),
	situacao VARCHAR(20),
	PRIMARY KEY(cnpj_conveniada, mes, ano),
	FOREIGN KEY (cnpj_conveniada) REFERENCES Conveniada(cnpj)
);
