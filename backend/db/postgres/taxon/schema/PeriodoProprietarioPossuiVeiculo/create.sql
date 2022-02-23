CREATE Table PeriodoProprietarioPossuiVeiculo(
	id INT,
  chassi VARCHAR(17),
  inicio DATETIME,
  fim DATETIME,
	PRIMARY KEY(id, chassi, inicio),
  FOREIGN KEY (id) REFERENCES ProprietarioPossuiVeiculo(id),
  FOREIGN KEY (chassi) REFERENCES ProprietarioPossuiVeiculo(chassi)
);
