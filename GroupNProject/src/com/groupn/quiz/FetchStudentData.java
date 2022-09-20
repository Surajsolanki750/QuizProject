package com.groupn.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class FetchStudentData {
	
	public static void studentData() {
		
		try {
			int index ;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Suraj@12345");
			PreparedStatement ps = connection.prepareCall("select * from candidatedata");
			ResultSet rs = ps.executeQuery();
			System.out.println("Enter Id");
			Scanner suraj = new Scanner(System.in);
			String akash = suraj.next();
			ArrayList<String> idColumn = new ArrayList<String>();
			ArrayList<String> firstName = new ArrayList<String>();
			ArrayList<String> lastName = new ArrayList<String>();
			ArrayList<String> score = new ArrayList<String>();
			ArrayList<String> grade = new ArrayList<String>();
			
			while (rs.next()) {
				idColumn.add(String.valueOf(rs.getInt(1)));
				firstName.add(String.valueOf(rs.getString("firstName")));
				lastName.add(String.valueOf(rs.getString("lastName")));
				score.add(String.valueOf(rs.getString("score")));
				grade.add(String.valueOf(rs.getString("grade")));
				}
//			System.out.println(idColumn);
//			System.out.println(firstName);
//			System.out.println(lastName);
//			System.out.println(score);
//			System.out.println(grade);
			if(idColumn.contains(akash)) {
//				System.out.println("Yes it has given input");
				index = idColumn.lastIndexOf(akash);
//				System.out.println(index);
				System.out.println("Name : "+firstName.get(index));
				System.out.println("Surname : "+lastName.get(index));
				System.out.println("Score : "+score.get(index));
				System.out.println("Grade : "+"\""+grade.get(index)+"\"");
				System.out.println();
			} else{
				System.out.println("Candidate not found");
				studentData();
			}
			connection.close();
			ps.close();
			rs.close();
//			suraj.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
