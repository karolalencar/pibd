package br.ufscar.dc.pibd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends GenericDAO{

    public String getRolebyLogin(String email) {

        String sqlUser = "SELECT * from users where email = ?";
        String role = "";
        try {
            // Conectando no banco e realizando consulta
            Connection conn = this.getConnection();
            PreparedStatement statementUser = conn.prepareStatement(sqlUser);
            statementUser.setString(1, email);
            ResultSet resultSetUser = statementUser.executeQuery();
            // Convertendo resultados para a classe interna Cliente
            
            if (resultSetUser.next()) {
                role = resultSetUser.getString("role");
            }
            
            resultSetUser.close();
            statementUser.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        
        return role;
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
