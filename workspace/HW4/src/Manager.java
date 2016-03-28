
public class Manager extends Employee {
	public static String department;

	public Manager(String name, double salary, String department){
		super(name, salary);
		Manager.department = department;
	}
	public void setDepartment(String department){
		Manager.department = department;
	}
	
	@Override
	public String toString() {
		return "Manager [name=" + name + ", salary=" + salary + ", department="+department+"]";
	}
	
	
}
