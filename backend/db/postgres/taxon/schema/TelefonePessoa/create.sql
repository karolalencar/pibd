CREATE TABLE TelefonePessoa(   
	id INT, 
    	ddd INT,
    	numero int,
    	tipo varchar(20),
    	criado_em TIMESTAMP,
    	PRIMARY key (id, ddd, numero),
    	FOREIGN key (id) REFERENCES PEssoa(id)
);
