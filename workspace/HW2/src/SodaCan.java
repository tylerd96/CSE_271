
public class SodaCan {
	
	private double radius;
	private double height;
	
	public SodaCan(double radius, double height) {
		super();
		this.radius = radius;
		this.height = height;
	}
	public double getSurfaceArea() {
		return (2*Math.PI*radius*height) + (2*Math.PI*Math.pow(radius,2));
	}
	public double getVolume() {
		return (Math.PI*Math.pow(radius, 2)*height);
	}
}