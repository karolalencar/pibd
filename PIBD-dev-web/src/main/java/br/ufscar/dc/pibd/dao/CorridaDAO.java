package br.ufscar.dc.pibd.dao;

import br.ufscar.dc.pibd.domain.Corrida;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CorridaDAO extends GenericDAO{
    
    public List<Corrida> getAllCorridasByMotoristaMesEAno(String cpfMotorista, Integer mes, Integer ano) {

        List<Corrida> corridas = new ArrayList<>();

        String sql= "SELECT * FROM recupera_corridas(?, ?, ?); ";

        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementAppointment = conn.prepareStatement(sql);
            statementAppointment = conn.prepareStatement(sql);
            statementAppointment.setString(1, cpfMotorista);
            statementAppointment.setInt(2, mes);
            statementAppointment.setInt(3, ano);

            ResultSet resultSet = statementAppointment.executeQuery();
            
            // Convertendo resultados para a classe interna Cliente
            while (resultSet.next()) {
                Double valor = resultSet.getDouble("valor");
                Long id = resultSet.getLong("id");
                LocalDate iniciaAs = LocalDate.parse(resultSet.getDate("inicia_as").toString());
                LocalDate terminaAs = LocalDate.parse(resultSet.getDate("inicia_as").toString());
                
                Corrida corrida = new Corrida( id, valor, iniciaAs, terminaAs);
                corridas.add(corrida);

            }
         
            resultSet.close();
            statementAppointment.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return corridas;
    }
}
