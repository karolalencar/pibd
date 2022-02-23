CREATE TABLE TelefonePessoa(
	id INT,
	telefone VARCHAR(20),
	PRIMARY KEY (id, telefone),
	FOREIGN KEY (id) REFERENCES Pessoa(id)
);
