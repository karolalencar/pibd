CREATE TABLE Garagem(
	chassi VARCHAR(17),
	cep CHAR(8),
	num INT,
	garagem VARCHAR(255),
	PRIMARY KEY (chassi, cep, num),
	FOREIGN KEY (chassi) REFERENCES Veiculo(chassi)
);
