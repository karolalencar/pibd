CREATE TABLE EnderecoPessoa(
	id INT,
	CEP char(8),
	num INT,
	PRIMARY KEY (id, CEP, num),
	FOREIGN KEY (id) REFERENCES Pessoa(id)
);
