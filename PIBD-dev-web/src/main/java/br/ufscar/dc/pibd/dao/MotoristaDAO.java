package br.ufscar.dc.pibd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;*/
import java.time.LocalDate;


import br.ufscar.dc.pibd.domain.Motorista;


public class MotoristaDAO extends GenericDAO {

    public Motorista getFisicaFromMotById(Long id) {
        Motorista motorista = null;
        
        String sqlMotorista = "SELECT * from fisica where id = ?";

        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementMotorista = conn.prepareStatement(sqlMotorista);
            statementMotorista.setLong(1, id);
            ResultSet resultSetMotorista = statementMotorista.executeQuery();

            // Convertendo resultados para a classe interna Cliente
            if (resultSetMotorista.next()) {
                String cpf = resultSetMotorista.getString("cpf");
                LocalDate dataNasc = LocalDate.parse(resultSetMotorista.getDate("data_nasc").toString());
                String estadoCivil = resultSetMotorista.getString("estado_civil");
                String rg = resultSetMotorista.getString("rg");

                                    
                motorista = new Motorista(cpf,  dataNasc,  estadoCivil,  rg);
            }       
           
            resultSetMotorista.close();
            statementMotorista.close();
        
            conn.close();
        } catch (SQLException e) {
        	System.out.println("ERRO: " + e);
            throw new RuntimeException(e);
        }
        return motorista;
    }

    public Double totalValorMotoristaMesEAno(String cpf, Integer ano, Integer mes) {
        String sqlMotorista = "SELECT recupera_lucro_total(?, ?, ?)";
        Double total = 0.0;
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementMotorista = conn.prepareStatement(sqlMotorista);
            statementMotorista.setString(1, cpf);
            statementMotorista.setInt(2, mes);
            statementMotorista.setInt(3, ano);
        
            ResultSet resultSetMotorista = statementMotorista.executeQuery();

            // Convertendo resultados para a classe interna Cliente
            if (resultSetMotorista.next()) {
                total = resultSetMotorista.getDouble(1);
            }       
           
            resultSetMotorista.close();
            statementMotorista.close();
        
            conn.close();
        } catch (SQLException e) {
        	System.out.println("ERRO: " + e);
            throw new RuntimeException(e);
        }
        return total;
    }
    
    public Integer totalCorridasMotoristaMesEAno(String cpf, Integer ano, Integer mes) {
        
        String sqlMotorista = "SELECT recupera_corridas_totais(?, ?, ?)";
        Integer total = 0;
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementMotorista = conn.prepareStatement(sqlMotorista);
            statementMotorista.setString(1, cpf);
            statementMotorista.setInt(2, mes);
            statementMotorista.setInt(3, ano);
        
            ResultSet resultSetMotorista = statementMotorista.executeQuery();

            // Convertendo resultados para a classe interna Cliente
            if (resultSetMotorista.next()) {
                total = resultSetMotorista.getInt(1);
            }       
           
            resultSetMotorista.close();
            statementMotorista.close();
        
            conn.close();
        } catch (SQLException e) {
        	System.out.println("ERRO: " + e);
            throw new RuntimeException(e);
        }
        return total;
    }


}