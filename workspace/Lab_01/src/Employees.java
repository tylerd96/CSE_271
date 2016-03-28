/**
 * @author tylerdavis
 * @version
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Employees {
	
	// Employee attributes
	public String id, FName, LName, city, state, zip, phone, Email;

	// Saves Employee attributes to file
	public void save(PrintWriter pw) throws Exception {
		pw.println(id);
		pw.println(FName);
		pw.println(LName);
		pw.println(city);
		pw.println(state);
		pw.println(zip);
		pw.println(phone);
		pw.println(Email);
	}
	// Loads Employee attributes from file
	public void load(Scanner fin) throws Exception {
		id = fin.nextLine();
		FName = fin.nextLine();
		LName = fin.nextLine();
		city = fin.nextLine();
		state = fin.nextLine();
		zip = fin.nextLine();
		phone = fin.nextLine();
		Email = fin.nextLine();
	}
	public String toString() {
		return String.format("%-10s %-10s %-17s %-10s %-9s %-8s %-15s %10s",
				FName,LName,id,city,state,zip,phone,Email);
	}

	
}
