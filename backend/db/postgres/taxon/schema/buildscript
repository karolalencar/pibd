create table Local(
    
    cep CHAR(8),
    num INT,
    PRIMARY key(cep,num)
);
CREATE Table Pessoa(
	id INT,
	email VARCHAR(255),
	nome VARCHAR(50),
	PRIMARY KEY(id)
);
CREATE Table Veiculo(
	chassi VARCHAR(17),
	cor VARCHAR(255),
	placa VARCHAR(7),
	ano INT,
	modelo VARCHAR(50),
	max_ocupacao INT,
	marca VARCHAR(50),
	PRIMARY KEY(chassi)
);
CREATE TABLE Proprietario(
	id INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES Pessoa(id)
);
CREATE Table ProprietarioPossuiVeiculo(
	id INT,
  	chassi VARCHAR(17),
	PRIMARY KEY(id, chassi),
  	FOREIGN KEY (id) REFERENCES Proprietario(id),
  	FOREIGN KEY (chassi) REFERENCES Veiculo(chassi)
);
CREATE TABLE Fisica(
	cpf CHAR(11),
	data_nasc DATE,
	estado_civil VARCHAR(20),
	rg VARCHAR(20), 
	id INT NOT NULL,
	PRIMARY KEY(cpf),
	FOREIGN KEY (id) REFERENCES Pessoa(id)
);
CREATE TABLE Motorista (
    cpf VARCHAR(11),
    renach VARCHAR(50),
    agencia_bancaria VARCHAR(10),
    conta_bancaria VARCHAR(10),
    banco VARCHAR(50),
    PRIMARY KEY (cpf),
	FOREIGN KEY (cpf) REFERENCES Fisica(cpf)
);
CREATE TABLE MotoristaAcessaVeiculo(
	cpf CHAR(11),
	chassi CHAR(17),
	PRIMARY KEY(cpf, chassi),
	FOREIGN KEY(cpf) REFERENCES Motorista(cpf),
	FOREIGN KEY(chassi) REFERENCES Veiculo(chassi)
);
CREATE TABLE MotoristaHabilitado(
	cpf CHAR(11),
	chassi CHAR(17),
	PRIMARY KEY(cpf, chassi),
	FOREIGN KEY(cpf, chassi) REFERENCES MotoristaAcessaVeiculo(cpf, chassi)
);
CREATE TABLE Passageiro(
	cpf CHAR(11),
	PRIMARY KEY (cpf),
	FOREIGN KEY (cpf) REFERENCES Fisica(cpf)
);
CREATE TABLE Juridica(
	cnpj CHAR(14),
	setor VARCHAR(30),
	id INT NOT NULL,
	PRIMARY KEY(cnpj),
	FOREIGN KEY(id) REFERENCES Pessoa(id)
);
CREATE TABLE Conveniada(
	cnpj CHAR(14),
	PRIMARY KEY(cnpj),
	FOREIGN KEY (cnpj) REFERENCES Juridica(cnpj)
);
CREATE TABLE ConveniadaAutorizaPassageiro(
	cnpj CHAR(14),
	cpf CHAR(11),
	status VARCHAR(20),
	cargo VARCHAR(20),
	PRIMARY KEY (cnpj, cpf),
	FOREIGN KEY (cnpj) REFERENCES Conveniada(cnpj),
	FOREIGN KEY (cpf) REFERENCES Passageiro(cpf)
);
CREATE TABLE PassageiroAutorizado(
	cnpj CHAR(14),
	cpf CHAR(11),
	PRIMARY KEY(cnpj, cpf),
	FOREIGN KEY(cnpj, cpf) REFERENCES ConveniadaAutorizaPassageiro(cnpj, cpf)
);
CREATE TABLE Fatura(
	cnpj CHAR(14),
    mes VARCHAR(10),
    ano CHAR(4),
	situacao VARCHAR(20),
	PRIMARY KEY(cnpj, mes, ano),
	FOREIGN KEY (cnpj) REFERENCES Conveniada(cnpj)
);
create table Agendamento(
    cnpj VARCHAR(14),
    efetuado_as TIMESTAMP,
    PRIMARY KEY(cnpj, efetuado_as),
    FOREIGN KEY(cnpj) REFERENCES Conveniada(cnpj) 
);
CREATE TABLE PassageiroAutorizadoViajaEmAgendamentoPorLocal(
	passageiro_autorizado_cpf CHAR(11),
	passageiro_autorizado_cnpj CHAR(14),
	agendamento_cnpj CHAR(14),
	agendamento_efetuado_as TIMESTAMP,
	cep CHAR(8),
	num INT,
	PRIMARY KEY (passageiro_autorizado_cpf, passageiro_autorizado_cnpj, agendamento_cnpj, agendamento_efetuado_as),
	FOREIGN KEY (passageiro_autorizado_cpf, passageiro_autorizado_cnpj) REFERENCES PassageiroAutorizado(cpf, cnpj),
	FOREIGN KEY (agendamento_cnpj, agendamento_efetuado_as) REFERENCES Agendamento(cnpj, efetuado_as),
	FOREIGN KEY (cep, num) REFERENCES Local(cep, num)
);
create table AgendamentoParaEmLocal(
    cnpj VARCHAR(14),
    efetuado_as TIMESTAMP,
    cep VARCHAR(8), 
    num INT,
    indice_trecho VARCHAR(255),
    num_passageiros INT,
    PRIMARY KEY (cnpj, efetuado_as, cep, num),
    FOREIGN KEY (cnpj, efetuado_as) REFERENCES Agendamento(cnpj, efetuado_as),
    FOREIGN KEY (cep, num) REFERENCES Local(cep, num)
);
CREATE TABLE Corrida(
	cpf CHAR(11),
	chassi CHAR(17),
	inicia_as TIMESTAMP,
	termina_as TIMESTAMP,
	valor REAL,
	inicia_em VARCHAR(50),
	termina_em VARCHAR(50),
	agendamento_cnpj CHAR(14),
	agendamento_efetuado_as TIMESTAMP,
	fatura_cnpj CHAR(14),
	fatura_mes VARCHAR(10),
	fatura_ano CHAR(4),
	PRIMARY KEY(cpf, chassi, inicia_as),
	FOREIGN KEY(cpf, chassi) REFERENCES MotoristaHabilitado(cpf, chassi),
	FOREIGN KEY(agendamento_cnpj, agendamento_efetuado_as) REFERENCES Agendamento(cnpj, efetuado_as),
	FOREIGN KEY(fatura_cnpj, fatura_mes, fatura_ano) REFERENCES Fatura(cnpj, mes, ano)
);
CREATE Table MotoristaContatoEmergencia(
	cpf VARCHAR(11),
	contato_emergencia VARCHAR(20),
	PRIMARY KEY(cpf, contato_emergencia),
	FOREIGN KEY (cpf) REFERENCES Motorista(cpf)
);
CREATE TABLE Garagem(
	chassi VARCHAR(17),
	garagem VARCHAR(255),
	PRIMARY KEY (chassi, garagem),
	FOREIGN KEY (chassi) REFERENCES Veiculo(chassi)
);
CREATE TABLE EnderecoPessoa(
	id INT,
	endereco VARCHAR(100),
	PRIMARY KEY (id, endereco),
	FOREIGN KEY (id) REFERENCES Pessoa(id)
);
CREATE TABLE Convenio(
	cnpj_conveniada CHAR(14),
    convenio VARCHAR(30) NOT NULL,
	PRIMARY KEY(cnpj_conveniada, convenio),
	FOREIGN KEY (cnpj_conveniada) REFERENCES Conveniada(cnpj)
);
CREATE TABLE TelefonePessoa(
	id INT,
	telefone VARCHAR(20),
	PRIMARY KEY (id, telefone),
	FOREIGN KEY (id) REFERENCES Pessoa(id)
);
CREATE TABLE MotoristaCNH (
    cpf CHAR(11),
    cnh CHAR(11),
    PRIMARY KEY (cpf, cnh),
    FOREIGN KEY (cpf) REFERENCES Motorista (cpf)
);
CREATE Table PeriodoProprietarioPossuiVeiculo(
	id INT,
  	chassi VARCHAR(17),
  	inicio TIMESTAMP,
  	fim TIMESTAMP,
	PRIMARY KEY(id, chassi, inicio),
  	FOREIGN KEY (id, chassi) REFERENCES ProprietarioPossuiVeiculo(id, chassi)
);
