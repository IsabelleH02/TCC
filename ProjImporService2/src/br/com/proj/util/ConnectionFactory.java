package br.com.proj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			Connection conn = null;
			Class.forName("org.sqlite.JDBC");
			String stringConnection = "jdbc:sqlite:C:\\banco\\dbDados.db";
			conn = DriverManager.getConnection(stringConnection);
			if (conn != null)
				return conn;
		} catch (ClassNotFoundException | SQLException ex) {
			System.err.println("ERRO: " + ex.toString());
			ex.printStackTrace();
		}
		return null;
		
	}
}
