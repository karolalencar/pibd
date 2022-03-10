CREATE TABLE Corrida(
	id SERIAL PRIMARY KEY,
	cpf CHAR(11),
	chassi CHAR(17),
	inicia_as TIMESTAMP,
	termina_as TIMESTAMP,
	valor REAL,
	inicia_em VARCHAR(50),
	termina_em VARCHAR(50),
	agendamento_id INT NOT NULL,
	fatura_id INT NOT NULL,
	UNIQUE(cpf, chassi, inicia_as),
	FOREIGN KEY(cpf, chassi) REFERENCES MotoristaHabilitado(cpf, chassi),
	FOREIGN KEY(agendamento_id) REFERENCES Agendamento(id),
	FOREIGN KEY(fatura_id) REFERENCES Fatura(id)
);
