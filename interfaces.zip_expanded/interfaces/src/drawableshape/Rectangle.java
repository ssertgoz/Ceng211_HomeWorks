package drawableshape;

public class Rectangle extends Shape implements Drawable {
	
	private double width, height;
	
	Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	@Override
	public void draw(int color) {
		System.out.println("Rectangle drawn with upper-left corner at (" + getX() + 
				", " + getY() + "), with width " + width + ", with height " + height + ", and color " + color);
	}

	public double calculateArea() {
		return width * height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}

}
