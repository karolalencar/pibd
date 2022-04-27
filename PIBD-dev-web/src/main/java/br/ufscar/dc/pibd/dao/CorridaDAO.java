package br.ufscar.dc.pibd.dao;

import br.ufscar.dc.pibd.domain.Corrida;
import br.ufscar.dc.pibd.domain.Passageiro;
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

    public Corrida getCorridaById(Long id) {
        List<Corrida> corridas = new ArrayList<>();
        String sql = "SELECT * FROM get_corridas_por_id(?)";

        try {
            // Conectando no banco e realizando consulta

            Connection conn = this.getConnection();
            PreparedStatement statementCorridas = conn.prepareStatement(sql);
            statementCorridas.setLong(1, id);

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

        try {

            String cpf_motorista = corridas.get(0).getCpf();
            sql = "SELECT id FROM fisica where cpf = ?";
            Connection conn = this.getConnection();
            PreparedStatement statementCorridas = conn.prepareStatement(sql);
            statementCorridas.setString(1, cpf_motorista);

            ResultSet resultSet = statementCorridas.executeQuery();
            while (resultSet.next()) {
                Integer id_motorista = resultSet.getInt("id");

                sql = "SELECT nome FROM pessoa where id = ?";
                PreparedStatement statementCorridas2 = conn.prepareStatement(sql);
                statementCorridas2.setInt(1, id_motorista);

                ResultSet resultSet2 = statementCorridas2.executeQuery();

                while (resultSet2.next()) {
                    String nome = resultSet2.getString("nome");
                    corridas.get(0).setNome_motorista(nome);
                }
                resultSet2.close();
                statementCorridas2.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return corridas.get(0);
    }

    public List<Passageiro> get_passageiros_locais(Long agendamento_id) {
        List<Passageiro> passageiros = new ArrayList<>();
        String sql = "SELECT * FROM get_passageiros_e_locais_por_agendamento(?)";

        try {
            // Conectando no banco e realizando consulta

            Connection conn = this.getConnection();
            PreparedStatement statementCorridas = conn.prepareStatement(sql);
            statementCorridas.setLong(1, agendamento_id);

            ResultSet resultSet = statementCorridas.executeQuery();

            while (resultSet.next()) {
                String cpf = resultSet.getString("passageiro_autorizado_cpf");
                String cep = resultSet.getString("cep");
                Integer num = resultSet.getInt("num");
                Passageiro p = new Passageiro(cpf, cep, num);

                passageiros.add(p);
            }

            resultSet.close();
            statementCorridas.close();
            conn.close();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        try {
            Connection conn = this.getConnection();
            for (Passageiro p : passageiros) {

                // Conectando no banco e realizando consulta
                sql = "SELECT id FROM fisica where cpf = ?";
                PreparedStatement statementCorridas = conn.prepareStatement(sql);
                statementCorridas.setString(1, p.getCpf());

                ResultSet resultSet = statementCorridas.executeQuery();
                System.out.println("AQUI");
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    System.out.println(id);

                    sql = "SELECT nome FROM pessoa where id = ?";
                    PreparedStatement statementCorridas2 = conn.prepareStatement(sql);
                    statementCorridas2.setInt(1, id);

                    ResultSet resultSet2 = statementCorridas2.executeQuery();

                    while (resultSet2.next()) {
                        String nome = resultSet2.getString("nome");
                        System.out.println(nome);
                        p.setNome(nome);
                    }
                    resultSet2.close();
                    statementCorridas2.close();

                }

                resultSet.close();
                statementCorridas.close();
            }
            conn.close();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return passageiros;
    }

}
