CREATE TABLE Proprietario(
	id INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES Pessoa(id)
);
