CREATE TABLE Fatura(
	id serial PRIMARY KEY,  -- surrogate PK
	cnpj CHAR(14),
    	data_criacao Date, 
	situacao VARCHAR(10) NOT NULL,
	FOREIGN KEY (cnpj) REFERENCES Conveniada(cnpj),
	CHECK(situacao IN ('em aberto', 'em atraso', 'quitada'))
);
