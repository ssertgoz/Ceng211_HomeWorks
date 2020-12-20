package point;

import java.awt.Color;

public class PointApp {

	public static void main(String[] args) {

		Point firstPoint = new Point();
		System.out.println("first point: " + firstPoint.toString());
		
		ColoredPoint secondPoint = new ColoredPoint(3.0, 4.0);
		System.out.println("second point: " + secondPoint.toString());
		
		secondPoint.setColor(Color.red);
		System.out.println("recolored second point: " + secondPoint.toString());
		
		System.out.println("distance from first to second point is "
				+ firstPoint.distanceTo(secondPoint));
	}

}
