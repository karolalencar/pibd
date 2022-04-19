package br.ufscar.dc.pibd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class GenericDAO {

    public GenericDAO() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        /* Conexão banco de dados postgresql */

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/taxon", "postgres", "password");
    }
}