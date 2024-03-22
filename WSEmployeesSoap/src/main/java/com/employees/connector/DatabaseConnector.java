package com.employees.connector;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnector {
	
	public static Connection getConnection() throws SQLException, NamingException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/CORSO2024");
            return ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            throw e;
        }
    
}
}
