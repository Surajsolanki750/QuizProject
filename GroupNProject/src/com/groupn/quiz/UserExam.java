package com.groupn.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserExam { 
	PreparedStatement preState = null;
	Connection conn = null;
	public void insertCandidateData(int id,String firstName,String lastName,int score, String grade) throws Throwable {  //int id,
		try {
			JdbcConnection connectionTest = new JdbcConnection();
			conn=connectionTest.getConnectionDetails();
			preState =conn.prepareStatement("insert into candidatedata(id,firstName,lastName,score,grade)values(?,?,?,?,?)");  //id,  //?,
			preState.setInt(1,id);
			preState.setString(2,firstName);
			preState.setString(3,lastName);
			preState.setInt(4,score);
			preState.setString(5,grade);
			int i = preState.executeUpdate();
			System.out.println("record is inserted successfully"+i);
			System.out.println("*********************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void input() throws Throwable{
		Scanner sc = new Scanner(System.in);
		int id;
		do {
			System.out.println("Enter ID :");
			while(!sc.hasNextInt()) {
		        System.out.println("Only numbers are accepted");
		        System.out.println("Please Enter ID again:");
		        sc.next();
		    }
			id = sc.nextInt();
		}while (id <= 0);
		System.out.println("Enter First Name : ");
		String firstName = sc.next();
		System.out.println("Enter Last Name : ");
		String lastName = sc.next();
		QuestionsSet j = new QuestionsSet();
		j.questions();
		int score = QuestionsSet.akss;
		System.out.println("Score ="+score);
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
		System.out.println("You got "+grade+" Grade");
		// don't edit anything from here	
		UserExam userInput = new UserExam();
		userInput.insertCandidateData(id, firstName, lastName, score, grade);  //id,
		
	}
}
//Class A- 8-10
//Class B- 6-8
//Class C- 5
//Class D- <5 then its fail>