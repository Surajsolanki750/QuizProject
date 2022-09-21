package com.groupn.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class UserExam { 
	PreparedStatement preState = null;
	Connection conn = null;
	public void insertCandidateData(int id,String firstName,String lastName,int score, String grade) throws Throwable {  //int id,
		try {
			JdbcConnection connectionTest = new JdbcConnection();
			conn=connectionTest.getConnectionDetails();
			preState =conn.prepareStatement("insert into data(id,firstName,lastName,score,grade)values(?,?,?,?,?)");  //id,  //?,
			preState.setInt(1,id);
			preState.setString(2,firstName);
			preState.setString(3,lastName);
			preState.setInt(4,score);
			preState.setString(5,grade);
			int i = preState.executeUpdate();
			System.out.println();
			System.out.println("Record is inserted successfully"+i);
			System.out.println();
			System.out.println("************************************************");
			ScannerSS.scannerSS();
		} catch (Exception e) {
			System.out.println();
		}
	}
	public static void input() throws Throwable{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Akash@525");
			PreparedStatement ps = connection.prepareCall("select * from data");
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> idColumn = new ArrayList<Integer>();
			while (rs.next()) {
				idColumn.add(Integer.valueOf(rs.getInt(1)));
			}	
		int id ;
		Scanner sc = new Scanner(System.in);
		FetchStudentData fsd = new FetchStudentData();
	
		do {
			System.out.print("Enter ID : ");
			if(!sc.hasNextInt()) { 
				System.out.println("-----------------------------------------------");
		        System.out.println("Only numbers are accepted\n"+ "Please Enter ID again");
		        System.out.println("-----------------------------------------------");
		        UserExam.input();
			}
			System.out.println("Please Enter ID again ");
		    if(idColumn.contains(sc.nextInt())){
		    System.out.println("ID is already present in database ");
		    System.out.println("-----------------------------------------------");
		    UserExam.input();
		    }
			id = sc.nextInt();
		}while (id <= 0);
		System.out.println("-----------------------------------------------");
		
		System.out.print("Enter First Name : " );
		String firstName = sc.next();
		
		System.out.println("-----------------------------------------------");
		
		System.out.print("Enter Last Name : ");
		String lastName = sc.next();
		System.out.println("-----------------------------------------------");
		System.out.println();
		System.out.println("***********************Quiz Started***********************");
		System.out.println();
		QuestionsSet j = new QuestionsSet();
		j.questions();
		int score = QuestionsSet.akss;
		System.out.println("Score = "+score);
		String grade = null;
		if(score >= 8 && score <= 10) {
			grade = "A";
		}else if(score >= 6 && score <= 7) {
			grade = "B";
		}else if(score >= 5 && score < 6) {
			grade = "C";
		}else {
			grade = "D";
		}
		System.out.println("You got "+grade+" Grade.");
		System.out.println("-----------------------------------------------");
		
		UserExam userInput = new UserExam();
		userInput.insertCandidateData(id, firstName, lastName, score, grade);  
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
	
	} 
		
}
