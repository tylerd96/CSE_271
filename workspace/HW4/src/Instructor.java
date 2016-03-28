
public class Instructor extends Person {
	public double salary;
	
	public Instructor(String name, int yearOfBirth, double salary){
		super(name,yearOfBirth);
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Instructor [name=" + name + ", yearOfBirth=" + yearOfBirth +", salary=" + salary + "]";
	}
	
	
}
