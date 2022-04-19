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
    	String url = "jdbc:mysql://localhost:3306/taxon";  	
    	return DriverManager.getConnection(url, "postgres", "password");
    }
}