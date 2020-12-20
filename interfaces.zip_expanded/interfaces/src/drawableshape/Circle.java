package drawableshape;

public class Circle extends Shape implements Drawable {
	
	private double radius;
	
	Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	@Override
	public void draw(int color) {
		System.out.println("Circle drawn at (" + getX() + ", " + getY() + 
				"), with radius " + radius + ", and color " + color);
	}
		
	public double calculateArea() {
		return radius*radius*3.14;
	}
	
	double getRadius() {
		return radius;
	}
	
}
