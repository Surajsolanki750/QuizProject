package com.groupn.quiz;

import java.util.Scanner;

public class Quiz {
	public static void usermenu() throws Throwable{
		System.out.println("Please choose from the following");
		System.out.println(" Press 1 to Start a Quiz");
		System.out.println(" Press 2 to Check all the Records");
		System.out.println(" Press 3 to Find the Perticular Id's Data"); 
		System.out.println(" Press 4 to Exit");
		System.out.println("-----------------------------------------------");
		Scanner sc = new Scanner(System.in);
		int select ;
		select = sc.nextInt();
		switch(select) {
		case 1:
	    System.out.println("-----------------------------------------------");	
		UserExam.input();
		ScannerSS.scannerSS();
		break;
		case 2:
		System.out.println("-----------------------------------------------");
		CandidatesData.check();
		ScannerSS.scannerSS();
		break;
		case 3:
		System.out.println("-----------------------------------------------");	
		FetchStudentData.studentData();

		ScannerSS.scannerSS();
		break;
		case 4:
		System.out.println("-------------------------Thank You-------------------------");
		System.exit(1);
		break;
		default:
		System.out.println("Wrong input Given ....\n" + "Please try again");
		usermenu();
		}
		sc.close();
	}
	public static void main(String[] args) throws Throwable {
		System.out.println("-------------------------*WELCOME*--------------------------");
		usermenu();
	}
}
