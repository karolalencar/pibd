CREATE TABLE Garagem(
	chassi VARCHAR(17),
	garagem VARCHAR(255),
	PRIMARY KEY (chassi, garagem),
	FOREIGN KEY (chassi) REFERENCES Veiculo(chassi)
);
