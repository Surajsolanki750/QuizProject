package com.groupn.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	
	Connection connection = null;
	public Connection getConnectionDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Akash@525");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}