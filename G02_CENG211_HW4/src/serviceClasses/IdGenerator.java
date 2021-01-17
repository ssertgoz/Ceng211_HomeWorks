package serviceClasses;

/* This IdGenerator class used to generate id for other classes,
 * All classes which include id, should extend this class
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public abstract class IdGenerator implements IIdGenerator {
	
	public int generateID() {
		double min = Math.pow(10, 3);
		double max = min*10 - 1;
		return (int)(Math.random() * (max - min + 1) + min);
	}
}
