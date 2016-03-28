/**
 * @author tylerdavis
 * @version
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	
	public static ArrayList<Employees> employee = new ArrayList<Employees>();
	
	public static void main(String[] args) {
		loadEmployees();
		areaCodeLookup("725");
		stateLookup("Ohio","OH");
		collegeInternExport();
	}
	// Loads the employee from the text file 
	public static void loadEmployees() {
		Scanner fin = null;
		Employees p;
		try {
			fin = new Scanner(new File("Lab_01.txt"));
			while(fin.hasNextLine()){
				p = new Employees();
				p.load(fin);
				employee.add(p);
			}
			fin.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(fin != null) fin.close();
		}
	}
	// Looks up the employee based on the area code
	public static void areaCodeLookup(String areaCode) {
			for(Employees p : employee) {
				if(p.phone.substring(1,4).equals(areaCode)) 
					System.out.println(p.toString());
			}
	}
	// Looks up the employee based on the state
	public static void stateLookup(String longName, String shortName) {
		for(Employees p : employee) {
			if(p.state.equalsIgnoreCase(longName) || p.state.equalsIgnoreCase(shortName))
				System.out.println(p.toString());
		}
	}
	// Looks up the employee based on Email
	public static void collegeInternExport() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("EDU_Students.txt"));
			for(Employees p:employee) 
				if(p.Email.endsWith(".edu"))
					p.save(pw);
			pw.close();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(pw != null) pw.close();
		}
	}

	 
}
