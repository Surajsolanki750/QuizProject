package com.groupn.quiz;

import java.util.Scanner;

public class ScannerSS {

	public static void scannerSS() throws Throwable {
		System.out.println("Please choose from the following");
		System.out.println(" Press 1 for main menu");
		System.out.println(" Press 2 for exit");
		Scanner pt = new Scanner(System.in);
		int select ;
		select = pt.nextInt();
		switch(select) {
		case 1:
		Quiz.usermenu();
		break;
		case 2:
		System.out.println("---Thank You---");
		System.exit(1);
		break;
		default:
		System.out.println("Wrong input....\n" + "please try again");
		scannerSS();
		}
		pt.close();

	}

}
