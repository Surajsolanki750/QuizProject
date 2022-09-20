package com.groupn.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class CandidatesData {
	
	public static void check() throws Throwable {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Akash@525");
			PreparedStatement ps = connection.prepareCall("select * from data");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println("ID : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Surname : "+rs.getString(3));
				System.out.println("Score : "+rs.getString(4));
				System.out.println("Grade : "+"\""+rs.getString(5)+"\"");
				
				System.out.println("-----------------------------------------------");
				
			}
			connection.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}}
