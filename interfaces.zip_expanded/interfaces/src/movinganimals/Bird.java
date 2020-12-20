package movinganimals;

public class Bird extends Animal implements IFlyable {
	
	private String name;
	
	public Bird(String name, String color) {
		super(color);
		this.name = name;
	}
	
	public void move(String location) {
		System.out.println(name + " moving to " + location);
	}

	public void fly(int speed) {
		System.out.println(name + " flying at " + speed + " km/h");
	}

	public String getName() {
		return name;
	}

}
