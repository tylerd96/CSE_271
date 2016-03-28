
public class Tester {
	public static void main(String args[]){
		
		//Tests the Letter class
		Letter let = new Letter("John","Mary");
		let.addLine("I am sorry we must part");
		let.addLine("I wish you all the best");
		System.out.println(let.getText());
		System.out.println("\n\n");
		
		//Tests the bug class
		Bug bugsy = new Bug(10);
		bugsy.move();
		bugsy.move();
		System.out.println(bugsy.getPosition());
		bugsy.turn();
		bugsy.move();
		bugsy.move();
		System.out.println(bugsy.getPosition());
		
		
	}
}
