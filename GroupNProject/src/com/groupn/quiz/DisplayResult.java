package com.groupn.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//import java.util.HashSet;
public class DisplayResult {
	
	
	public static void check() throws Throwable {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Suraj@12345");
			PreparedStatement ps = connection.prepareCall("select * from candidatedata");
			ResultSet rs = ps.executeQuery();
			String id = "grade";
			
			System.out.println(rs.findColumn(id));
			while(rs.next()){
				//System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				System.out.println("ID ="+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Surname : "+rs.getString(3));
				System.out.println("Score : "+rs.getString(4));
				System.out.println("Grade : "+"\""+rs.getString(5)+"\"");
				System.out.println();
				System.out.println();
				
			}
			connection.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public static void main(String[] args) throws Throwable {
		check();
	}
}



//ArrayList alist = new ArrayList();
//alist.add(rs.getInt(1));
//System.out.println(alist);