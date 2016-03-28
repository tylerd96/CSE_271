
public class Tester {
	
	public static void main(String[] args) {
		
		BetterRectangle rect1 = new BetterRectangle(10,10,5,15);
		BetterRectangle rect2 = new BetterRectangle(2,5,14,8);
		
		System.out.println("Area 1: " + rect1.getArea());
		System.out.println("Perimeter 1: " + rect1.getPerimeter());
		System.out.println("Area 2:" + rect2.getArea());
		System.out.println("Perimeter 2:" + rect2.getPerimeter());
	}
}
