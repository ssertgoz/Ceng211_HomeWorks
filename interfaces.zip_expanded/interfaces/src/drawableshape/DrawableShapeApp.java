package drawableshape;

public class DrawableShapeApp {

	public static void main(String[] args) {
		
		Drawable[] drawables = new Drawable[] { 
				new Circle(10, 20, 15), 
				new Circle(30, 20, 10),
				new Rectangle(5, 8, 8, 9) };
		
		for (int i = 0; i < drawables.length; i++)
			drawables[i].draw(Drawable.RED);

		for (int i = 0; i < drawables.length; i++) {
			Shape shape = (Shape)drawables[i];
			System.out.println("Area of " + shape.getClass() + " = " + shape.calculateArea());
		}
	}

}
