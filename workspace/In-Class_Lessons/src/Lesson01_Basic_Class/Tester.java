package Lesson01_Basic_Class;

import java.awt.Color;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static ArrayList<Student> students = new ArrayList<Student>();

	public static void main(String[] args) {
		
//		loadStudents();
//
//		Student s = new Student();
//		s.age = 22;
//		s.firstName = "Mike";
//		s.lastName = "Stahr";
//		s.gpa = 3.0;
//		s.hairColor = Color.BLACK;
//		s.isMale = true;
//		s.test1 = 90;
//		s.test2 = 90;
//		s.test3 = 90;
//		s.test4 = 100;
//		
//		students.add(s);
//		
//		saveStudents();
//
//		students.clear();
		
		loadStudents();
		
		printStudents("");

	}

	
	
	private static void printStudents(String byLetterGrade) {
		for(Student s : students)
			if(byLetterGrade.length() == 0 || s.getLetterGrade().equalsIgnoreCase(byLetterGrade))
				System.out.println(s);
	}

	public static void saveStudents() {
		PrintWriter pw = null;	
		try {
			pw = new PrintWriter(new File("students.txt"));

			for(Student s : students)
				s.save(pw);

			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(pw != null) pw.close();
		}
	}

	public static void loadStudents() {
		Student s;
		Scanner fin = null;
		try {
			fin = new Scanner(new File("students.txt"));
			while(fin.hasNextLine()) {
				s = new Student();
				s.load(fin);
				students.add(s);
			}
			fin.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(fin != null) fin.close();
		}
	}

}