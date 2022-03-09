CREATE TABLE TelefonePessoa(   
	id INT, 
    	ddd INT,
    	numero int,
    	tipo varchar(20) NOT NULL,
    	criado_em TIMESTAMP NOT NULL,
    	PRIMARY key (id, ddd, numero),
    	FOREIGN key (id) REFERENCES PEssoa(id)
);
