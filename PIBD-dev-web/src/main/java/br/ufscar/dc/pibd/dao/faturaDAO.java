package br.ufscar.dc.pibd.dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;*/
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.pibd.domain.Fatura;
import br.ufscar.dc.pibd.domain.Corrida;

public class faturaDAO extends GenericDAO {
    public Fatura getFaturaByCnpjDataCriacao(String cnpj, long data_criacao) {
        Fatura fatura = null;
        String sql = "SELECT * FROM get_fatura(?, ?)";
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementFatura = conn.prepareStatement(sql);
            statementFatura.setString(1, cnpj.replaceAll("\\s+", ""));
            java.sql.Date sqlData_criacao = new java.sql.Date(data_criacao);
            statementFatura.setDate(2, sqlData_criacao);

            ResultSet resultSetFatura = statementFatura.executeQuery();

            if (resultSetFatura.next()) {
                Integer id = resultSetFatura.getInt("id");
                String cnpj_in = resultSetFatura.getString("cnpj");
                Date data_criacao_in = resultSetFatura.getDate("data_criacao");
                String situacao = resultSetFatura.getString("situacao");

                fatura = new Fatura(id, cnpj_in, data_criacao_in, situacao);
            }

            resultSetFatura.close();
            statementFatura.close();

            conn.close();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e);
            throw new RuntimeException(e);
        }
        return fatura;

    }

    public List<Corrida> getCorridasByFaturaId(Integer id) {
        List<Corrida> corridas = new ArrayList<>();
        String sql = "SELECT * FROM get_corridas_fatura(?)";

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

    public Double getValorFaturaPorId(Integer fatura_id) {
        Double valor_total = null;
        String sql = "select * from total_valor_corridas_fatura(?)";
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementFatura = conn.prepareStatement(sql);
            statementFatura.setInt(1, fatura_id);

            ResultSet resultSetFatura = statementFatura.executeQuery();

            if (resultSetFatura.next()) {
                valor_total = resultSetFatura.getDouble("total_valor_corridas_fatura");
            }

            resultSetFatura.close();
            statementFatura.close();

            conn.close();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e);
            throw new RuntimeException(e);
        }
        return valor_total;

    }

    public Long getNumCorridasFaturaPorId(Integer fatura_id) {
        Long valor_total = null;
        String sql = "select * from num_corridas_fatura(?)";
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementFatura = conn.prepareStatement(sql);
            statementFatura.setInt(1, fatura_id);

            ResultSet resultSetFatura = statementFatura.executeQuery();

            if (resultSetFatura.next()) {
                valor_total = resultSetFatura.getLong("num_corridas_fatura");
            }

            resultSetFatura.close();
            statementFatura.close();

            conn.close();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e);
            throw new RuntimeException(e);
        }
        return valor_total;

    }

}
