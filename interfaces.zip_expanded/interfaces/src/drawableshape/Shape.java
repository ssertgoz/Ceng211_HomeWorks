package drawableshape;

public abstract class Shape {

	private double x, y;
	
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	double getX() {
		return x;
	}
	
	double getY() {
		return y;
	}
	
	public abstract double calculateArea();
	
}
