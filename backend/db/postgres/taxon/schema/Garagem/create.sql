CREATE TABLE Garagem(
	chassi VARCHAR(17),
	garagem VARCHAR(255),
	PRIMARY KEY (id, garagem),
	FOREIGN KEY (chassi) REFERENCES Veiculo(chassi)
);
