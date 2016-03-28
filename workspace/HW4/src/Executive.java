
public class Executive extends Manager {

	public Executive(String name, double salary){
		super(name, salary,Manager.department);
	}
	
	
	@Override
	public String toString() {
		return "Executive [name=" + name + ", salary=" + salary + "]";
	}
	
}
