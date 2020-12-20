package movinganimals;

public class MovingAnimalsApp {

	public static void main(String[] args) {

		Animal gull = new Bird("Gull", "White");
		gull.move("Egean See");
		Bird gull2 = (Bird)gull;
		gull2.fly(20);
		
		Fish shark = new Fish("Shark", "Gray");
		shark.move("Atlantic Ocean");
		shark.swim(40);		
	}
}
