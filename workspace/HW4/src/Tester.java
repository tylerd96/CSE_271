import java.util.ArrayList;

public class Tester {
	
	public static ArrayList<Person> people = new ArrayList<Person>();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		primeArray();
		printArray();

	}

	private static void printArray() {
		for(Person p:people)
			System.out.println(p);
		System.out.println();
		for(Employee e : employees)
			System.out.println(e);
		
	}

	private static void primeArray() {
		people.add(new Student("Tyler Davis",1996, "Computer Science"));
		people.add(new Student("John Walker", 1738, "Art"));
		people.add(new Instructor("Donald Trump", 1789, 100000));
		people.add(new Instructor("Bernie Sanders", 1123, 5));
		
		employees.add(new Employee("Barack Obama", 189877));
		employees.add(new Employee("Jeb Bush", 790201));
		employees.add(new Manager("Lionel Messi",56876, "Industry"));
		employees.add(new Executive("Jessie J", 89938));
		
		
	}
}

