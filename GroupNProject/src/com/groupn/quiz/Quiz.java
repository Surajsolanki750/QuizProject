package com.groupn.quiz;

import java.util.Scanner;

public class Quiz {
	public static void usermenu() throws Throwable{
		System.out.println("Please choose from the following");
		System.out.println(" Press 1 to take quiz");
		System.out.println(" Press 2 to check record");
		System.out.println(" Press 3 to find data"); 
		System.out.println(" Press 4 to exit");
		Scanner sc = new Scanner(System.in);
		int select ;
		select = sc.nextInt();
		switch(select) {
		case 1:
		UserExam.input();
		ScannerSS.scannerSS();
		break;
		case 2:
		CandidatesData.check();
		ScannerSS.scannerSS();
		break;
		case 3:
		FetchStudentData.studentData();
//		Quiz.menu();
		ScannerSS.scannerSS();
		break;
		case 4:
		System.out.println("---Thank You---");
		System.exit(1);
		break;
		default:
		System.out.println("Wrong input....\n" + "please try again");
		usermenu();
		}
		sc.close();
	}
	public static void main(String[] args) throws Throwable {
		System.out.println("----*WELCOME*-----");
		usermenu();
	}
}
