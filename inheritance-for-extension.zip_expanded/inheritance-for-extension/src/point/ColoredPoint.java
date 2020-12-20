package point;

import java.awt.Color;

public class ColoredPoint extends Point {

	private Color color;
	
	public ColoredPoint() {
		super();
		color = Color.black;
	}
	
	public ColoredPoint(double x, double y) {
		this(x, y, Color.black);
	}

	public ColoredPoint(double x, double y, Color color) {
		super(x ,y);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ColoredPoint [color=" + color.toString() + super.toString();
	}


}
