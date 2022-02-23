CREATE TABLE Fisica(
	cpf CHAR(11),
	data_nasc DATE,
	estado_civil VARCHAR(20),
	rg VARCHAR(20), 
	id INT NOT NULL,
	PRIMARY KEY(cpf),
	FOREIGN KEY (id) REFERENCES Pessoa(id)
);
