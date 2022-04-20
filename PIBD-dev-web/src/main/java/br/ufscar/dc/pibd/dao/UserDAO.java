package br.ufscar.dc.pibd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufscar.dc.pibd.domain.User;

public class UserDAO extends GenericDAO {

    public String getRolebyLogin(String email) {

        String sqlUser = "SELECT * from pessoa where email = ?";
        String role = "";
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementUser = conn.prepareStatement(sqlUser);
            statementUser.setString(1, email);
            ResultSet resultSetUser = statementUser.executeQuery();
            // Convertendo resultados para a classe interna Cliente

            if (resultSetUser.next()) {
                role = resultSetUser.getString("papel");
            }

            resultSetUser.close();
            statementUser.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return role;
    }

    public User getUserbyLogin(String email) {

        String sqlUser = "SELECT * from pessoa where email = ?";
        String role = "";
        String nome = "";
        String password = "";
        Long id = 0L;
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementUser = conn.prepareStatement(sqlUser);
            statementUser.setString(1, email);
            ResultSet resultSetUser = statementUser.executeQuery();
            // Convertendo resultados para a classe interna Cliente

            if (resultSetUser.next()) {
                id = resultSetUser.getLong("id");
                nome = resultSetUser.getString("nome");
                password = resultSetUser.getString("senha");
                role = resultSetUser.getString("papel");
            }

            resultSetUser.close();
            statementUser.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        User user = new User(id, nome, email, password, role);

        return user;
    }

    public Boolean getPassed(String email, String password) {

        String sqlUser = "Select check_password(?, ?);";
        Boolean bool = false;
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementUser = conn.prepareStatement(sqlUser);
            statementUser.setString(1, email);
            statementUser.setString(2, password);
            ResultSet resultSetUser = statementUser.executeQuery();
            // Convertendo resultados para a classe interna Cliente

            if (resultSetUser.next()) {
                bool = resultSetUser.getBoolean("check_password");
            }

            resultSetUser.close();
            statementUser.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return bool;
    }

}
