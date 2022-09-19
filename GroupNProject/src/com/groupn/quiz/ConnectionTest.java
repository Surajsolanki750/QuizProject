package com.groupn.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	
	Connection connection = null;
	public Connection getConnectionDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Suraj@12345");
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
