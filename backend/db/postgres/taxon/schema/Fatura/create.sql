CREATE TABLE Fatura(
	id serial PRIMARY KEY,  -- surrogate PK
	cnpj CHAR(14),
    	mes VARCHAR(10),
    	ano CHAR(4),
	situacao VARCHAR(10) NOT NULL,
	UNIQUE(cnpj, mes, ano),
	FOREIGN KEY (cnpj) REFERENCES Conveniada(cnpj),
	CHECK(situacao IN ('em aberto', 'em atraso', 'quitada'))
);
