package br.ufscar.dc.pibd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;*/
import java.time.LocalDate;

import br.ufscar.dc.pibd.domain.Client;
import br.ufscar.dc.pibd.domain.Corrida;

public class ClientDAO extends GenericDAO {
    public String getCnpjById(Integer id) {
        String cnpj = null;
        String sql = "SELECT * FROM get_cnpj_conveniada(?)";
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementFatura = conn.prepareStatement(sql);
            statementFatura.setInt(1, id);

            ResultSet resultSetFatura = statementFatura.executeQuery();

            if (resultSetFatura.next()) {
                cnpj = resultSetFatura.getString("get_cnpj_conveniada");
            }

            resultSetFatura.close();
            statementFatura.close();

            conn.close();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e);
            throw new RuntimeException(e);
        }
        return cnpj;
    }
}
