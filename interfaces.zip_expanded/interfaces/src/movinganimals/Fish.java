package movinganimals;

public class Fish extends Animal implements ISwimmable {
	
	private String name;
	
	public Fish(String name, String color) {
		super(color);
		this.name = name;
	}
	
	public void move(String location) {
		System.out.println(name + " moving to " + location);
	}

	public void swim(int speed) {
		System.out.println(name + " swimming at " + speed + " km/h");
	}

	public String getName() {
		return name;
	}

}
