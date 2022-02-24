CREATE Table PeriodoProprietarioPossuiVeiculo(
	id INT,
  	chassi VARCHAR(17),
  	inicio TIMESTAMP,
  	fim TIMESTAMP,
	PRIMARY KEY(id, chassi, inicio),
  	FOREIGN KEY (id, chassi) REFERENCES ProprietarioPossuiVeiculo(id, chassi)
);
