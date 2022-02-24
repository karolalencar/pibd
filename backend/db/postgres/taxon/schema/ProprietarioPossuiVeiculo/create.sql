CREATE Table ProprietarioPossuiVeiculo(
	id INT,
  	chassi VARCHAR(17),
	PRIMARY KEY(id, chassi),
  	FOREIGN KEY (id) REFERENCES Proprietario(id),
  	FOREIGN KEY (chassi) REFERENCES Veiculo(chassi)
);
