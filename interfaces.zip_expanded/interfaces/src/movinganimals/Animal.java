package movinganimals;

public abstract class Animal implements IMovable {

	private String color;
	
	public Animal(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
}
