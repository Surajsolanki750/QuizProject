package com.groupn.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class QuestionsSet {
	
	public static int akss;

	public void questions() {
		String q1 = "Java is a Successor to which programming language?\n" +
	            "(a)B\n(b)7\n(c)C++\n(d)D\n";
		
		String q2 = "Who invented Java language?\n" +
				"(a)Dennis Ritchie\n(b)James Gosling\n(c)Larry Page\n(d)Serge Page\n";
		
		String q3 = "What is the original name of Java Programming language?\n" +
				"(a)J++\n(b)C++\n(c)OAK\n(d)TEAK\n";
		
		String q4 = "The name \"JAVA\" is known to the world as?\n" +
				"(a)A Tea Brand in India\n(b)A Coffee Brand in Africa\n(c)An Island in Indonesia\n(d)Ragi Malt Juice\n";
		
		String q5 = "A character literal in Java is enclosed within a pair of ___?\n" +
				"(a)Square brackets\n(b)Double Quotes\n(c)Single Quotes\n(d)Exclamations\n";
		
		String q6 = "An abstract class in Java usually contains one or more abstract ____.\n" +
	            "(a)constructors\n(b)methods\n(c)variables\n(d)None\n";
		
		String q7 = "What is the default boolean literal assigned to a boolean variable in Java?\n" +
				"(a)true\n(b)false\n(c)undefined\n(d)None of the above\n";
		
		String q8 = "An abstract class with 100% abstract methods is equivalent to ______.\n" +
				"(a)Interface\n(b)Concrete class\n(c)Virtual Class\n(d)All the above\n";
		
		String q9 = "Choose a correct statement about abstract classes?\n" +
				"(a)An abstract class can extend a concrete class\n(b)An abstract class can extend another abstract class\n(c)An abstract class can implement any number of interfaces.\n(d)All the above.\n";
		
		String q10 = "An abstract class can define ____ inside of it.\n" +
				"(a)Inner abstract class\n(b)Inner concrete class\n(c)static methods\n(d)All the above\n";
		
		HashMap<String,String> que = new HashMap<String,String>();
				que.put(q1 , "c");
				que.put(q2 , "b");
				que.put(q3 , "c");
				que.put(q4 , "c");
				que.put(q5 , "c");
				que.put(q6 , "b");
				que.put(q7 , "b");
				que.put(q8 , "a");
				que.put(q9 , "d");
				que.put(q10 , "d");
				QuestionsSet q = new QuestionsSet();
		q.takeTest(que);	
	}
	void takeTest(HashMap<String,String> que) {
		int score = 0;
		Scanner sc =new Scanner(System.in);
		Iterator<HashMap.Entry<String, String>> itr = que.entrySet().iterator();
		while (itr.hasNext()) {
			HashMap.Entry<String, String> entry = itr.next();  
			System.out.println(entry.getKey());
			System.out.println("enter ur ans");
			String answer = sc.nextLine();
			if (answer.equals(entry.getValue())) {
				score++;		
			}
		}
		System.out.println("u got" + "=" + score + "/" + que.size());	
		
		akss = score;
	}
}
