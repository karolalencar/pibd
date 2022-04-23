package br.ufscar.dc.pibd.dao;

import br.ufscar.dc.pibd.domain.Corrida;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CorridaDAO extends GenericDAO {

    public List<Corrida> getAllCorridasByMotoristaMesEAno(String cpfMotorista, Integer ano, Integer mes) {
        List<Corrida> corridas = new ArrayList<>();
        System.out.print("CPF:" + cpfMotorista + "\n mes:" + mes + "\nano:" + ano);
        String sql = "SELECT * FROM recupera_corridas(?, ?, ?)";

        try {
            // Conectando no banco e realizando consulta

            Connection conn = this.getConnection();
            PreparedStatement statementCorridas = conn.prepareStatement(sql);
            statementCorridas.setString(1, cpfMotorista);
            statementCorridas.setInt(2, mes);
            statementCorridas.setInt(3, ano);

            ResultSet resultSet = statementCorridas.executeQuery();

            while (resultSet.next()) {

                Double valor = resultSet.getDouble("valor_total");
                Integer id = resultSet.getInt("id_corrida");
                LocalDate iniciaAs = LocalDate.parse(resultSet.getDate("data_inicio").toString());
                LocalDate terminaAs = LocalDate.parse(resultSet.getDate("data_fim").toString());
                System.out.print("id = " + id);
                Corrida corrida = new Corrida(id, valor, iniciaAs, terminaAs);
                corridas.add(corrida);

            }

            resultSet.close();
            statementCorridas.close();
            conn.close();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return corridas;
    }

    public Corrida getCorridaById(Integer id) {
        List<Corrida> corridas = new ArrayList<>();
        String sql = "SELECT * FROM get_corridas_por_id(?)";

        try {
            // Conectando no banco e realizando consulta

            Connection conn = this.getConnection();
            PreparedStatement statementCorridas = conn.prepareStatement(sql);
            statementCorridas.setInt(1, id);

            ResultSet resultSet = statementCorridas.executeQuery();

            while (resultSet.next()) {

                Double valor = resultSet.getDouble("valor");
                Integer id_ = resultSet.getInt("id");
                LocalDate iniciaAs = LocalDate.parse(resultSet.getDate("inicia_as").toString());
                LocalDate terminaAs = LocalDate.parse(resultSet.getDate("termina_as").toString());
                String cpf = resultSet.getString("cpf");
                String chassi = resultSet.getString("chassi");
                String inicia_em = resultSet.getString("inicia_em");
                String termina_em = resultSet.getString("termina_em");
                Long agendamento_id = resultSet.getLong("agendamento_id");
                Long fatura_id = resultSet.getLong("fatura_id");
                Corrida corrida = new Corrida(id_, cpf, chassi, iniciaAs, terminaAs, valor, inicia_em, termina_em,
                        (Long) agendamento_id, (Long) fatura_id);
                corridas.add(corrida);
            }

            resultSet.close();
            statementCorridas.close();
            conn.close();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return corridas.get(0);
    }

}
