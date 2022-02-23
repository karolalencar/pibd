CREATE TABLE Juridica(
	cnpj CHAR(14),
	setor VARCHAR(30),
	id INT,
	PRIMARY KEY(cnpj),
	FOREIGN KEY(id) REFERENCES Pessoa(id)
);
