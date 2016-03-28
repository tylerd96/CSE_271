
public abstract class Person {
	public String name;
	public int yearOfBirth;
	
	public Person(String name, int yearOfBirth) {
		this.name = name;
		this.yearOfBirth = yearOfBirth;
	}
	public String toString() {
		return "Person [name=" + name + ", yearOfBirth=" + yearOfBirth + "]";
	}
	
	
}
