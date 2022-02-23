CREATE TABLE EnderecoPessoa(
	id INT,
	endereco VARCHAR(100),
	PRIMARY KEY (id, endereco),
	FOREIGN KEY (id) REFERENCES Pessoa(id)
);
