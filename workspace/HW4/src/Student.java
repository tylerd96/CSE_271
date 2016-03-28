
public class Student extends Person {
	public String major;
	
	public Student(String name, int yearOfBirth, String major){
		super(name,yearOfBirth);
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", yearOfBirth=" + yearOfBirth +", major=" + major +  "]";
	}

	

	
}
