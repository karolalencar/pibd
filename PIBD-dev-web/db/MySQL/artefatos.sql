/* Começo Artefatos Áquila */

CREATE VIEW Pessoa_login AS SELECT email, senha FROM Pessoa;

REATE FUNCTION check_password(uname TEXT, pass TEXT)
RETURNS BOOLEAN AS'
DECLARE passed BOOLEAN;
BEGIN
        SELECT  (senha = $2) INTO passed
        FROM    Pessoa_login
        WHERE   email = $1;

        RETURN passed;
END;
'
LANGUAGE plpgsql;

CREATE VIEW corridas_view AS SELECT id, cpf,valor, inicia_as, termina_as FROM Corrida;

CREATE OR REPLACE FUNCTION recupera_corridas(cpfNumber text, mes integer, ano integer)
  RETURNS TABLE (id_corrida BIGINT
	       , valor_recebido REAL
	       , valor_total  REAL
	       , data_inicio  TIMESTAMP
	       , data_fim     TIMESTAMP)
  LANGUAGE plpgsql AS
$func$
BEGIN
   RETURN QUERY
   select id::BIGINT as id_corrida,(valor*0.6)::REAL as valor_recebido, valor as valor_total, inicia_as as data_inicio, termina_as as data_fim from corridas_view where cpf = $1 and EXTRACT(MONTH FROM inicia_as) = $2 and EXTRACT(YEAR FROM inicia_as)= $3;                  
END
$func$;

CREATE OR REPLACE FUNCTION recupera_lucro_total(cpfNumber text, mes integer, ano integer)
  RETURNS REAL
  LANGUAGE plpgsql AS
$func$
DECLARE 
  cur corrida%ROWTYPE;
  total REAL;
BEGIN
   total := 0.0;
   FOR cur in 
	SELECT * FROM corrida WHERE cpf =$1 AND EXTRACT(MONTH FROM inicia_as) = $2 AND EXTRACT(YEAR FROM inicia_as)= $3
   LOOP
	total := total + cur.valor * 0.6;
   	END LOOP;
   RETURN total;
END;
$func$;

CREATE OR REPLACE FUNCTION recupera_corridas_totais(cpfNumber text, mes integer, ano integer)
  RETURNS BIGINT
  LANGUAGE plpgsql AS
$func$
DECLARE 
  cur corrida%ROWTYPE;
  total BIGINT;
BEGIN
   total := 0;
   FOR cur in 
	SELECT * FROM corrida WHERE cpf =$1 and EXTRACT(MONTH FROM inicia_as) = $2 and EXTRACT(YEAR FROM inicia_as)= $3
   LOOP
	total := total + 1;
   	END LOOP;
   RETURN total;
END;
$func$;

/* Fim Artefatos Áquila */

/* Começo artefatos Gustavo Jodar */

CREATE OR REPLACE FUNCTION insert_fatura(cnpj character(14),data_criacao Date, situacao character varying)
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO fatura(cnpj, data_criacao, situacao)
        VALUES(cnpj, data_criacao, situacao);
      END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION get_fatura(cnpj_ character(14),data_criacao_ Date)
  RETURNS setof fatura AS
  $BODY$
      BEGIN
        RETURN QUERY SELECT * FROM fatura WHERE cnpj=cnpj_ AND EXTRACT(MONTH FROM data_criacao)= EXTRACT(MONTH FROM data_criacao_);
      END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION confere_fatura() 
	RETURNS trigger AS $$
	DECLARE
	  cur fatura%ROWTYPE;
	  current_date Date;
	BEGIN
	  FOR cur in 
	  	SELECT * FROM fatura WHERE (situacao = 'em aberto')
	  LOOP
	  	IF current_date >= cur.data_criacao+ integer '14' THEN
			UPDATE fatura SET situacao='em atraso' WHERE cnpj=cur.cnpj AND data_criacao=cur.data_criacao;
	  	END IF;
		END LOOP;
	  RETURN NEW;
	END;
	$$ LANGUAGE plpgsql;

CREATE TRIGGER check_pagamentos
BEFORE INSERT ON fatura 
FOR EACH ROW EXECUTE PROCEDURE confere_fatura();



CREATE OR REPLACE FUNCTION get_cnpj_conveniada(bigint) RETURNS char(16)
    AS 'select cnpj from juridica where juridica.id = $1;'
    LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;

CREATE OR REPLACE FUNCTION total_valor_corridas_fatura(bigint) RETURNS real
    AS 'select sum(valor) from corrida where fatura_id = $1'
    LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;

CREATE OR REPLACE FUNCTION num_corridas_fatura(bigint) RETURNS bigint
    AS 'select count(*) from corrida where fatura_id = $1'
    LANGUAGE SQL
    IMMUTABLE
    RETURNS NULL ON NULL INPUT;

CREATE OR REPLACE FUNCTION get_corridas_fatura(id_ bigint)
  RETURNS setof corrida AS
  $BODY$
      BEGIN
        RETURN QUERY SELECT * FROM corrida WHERE fatura_id=id_;
      END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION get_corridas_por_id(id_ bigint)
  RETURNS setof corrida AS
  $BODY$
      BEGIN
        RETURN QUERY SELECT * FROM corrida WHERE corrida.id=id_;
      END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

create or replace view locais as select * from local

CREATE OR REPLACE FUNCTION get_passageiros_e_locais_por_agendamento(id_ BIGINT)
  RETURNS setof PassageiroAutorizadoViajaEmAgendamentoPorLocal AS
  $BODY$
      BEGIN
        RETURN QUERY SELECT * FROM PassageiroAutorizadoViajaEmAgendamentoPorLocal
			WHERE agendamento_id=id_;
      END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION cria_fatura() 
	RETURNS trigger AS $$
	DECLARE
	  cur fatura%ROWTYPE;
	  current_date Date;
	BEGIN
	  FOR cur in 
	  	SELECT * FROM fatura f WHERE f.cnpj = NEW.cnpj ORDER BY id DESC LIMIT 1
	  LOOP
	  	IF EXTRACT(DAY FROM current_date) = integer '27' THEN
			IF cur.data_criacao < current_date THEN
				insert into fatura (cnpj, data_criacao, situacao) values
					(NEW.cnpj, current_date, 'em aberto') ;
	  		END IF;
		END IF;
		END LOOP;
	  RETURN NEW;
	END;
	$$ LANGUAGE plpgsql;

CREATE TRIGGER check_nova_fatura
BEFORE INSERT ON agendamento 
FOR EACH ROW EXECUTE PROCEDURE cria_fatura();


/* Fim artefatos Gustavo Jodar */
