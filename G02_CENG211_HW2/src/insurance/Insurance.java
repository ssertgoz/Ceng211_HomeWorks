package insurance;

import insuredValue.InsuredValue;

/**   
 * This is our Insurance class. It  has the fixed fee.
 * It is also an abstract class due to include abstract calculatePolicyCharge method 
 * It has also overridden toString Method
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public abstract class Insurance {
	
	private int fixedFee;
	
	// Getter and Setter
	public int getFixedFee() {
		return fixedFee;
	}
	public void setFixedFee(int fixedFee) {
		this.fixedFee = fixedFee;
	}

	// Generate random fixed fee between 3000 and 1000
	public static int getRandomFixedFee() {
		return (int)(Math.random()*(3000 - 1000) + 1000);
	}
	// Overloaded
	public static int getRandomFixedFee(int max, int min) {
		return (int)(Math.random()*(max - min) + min);
	}
	
	@Override
	public String toString() {
		return "The policy charge of ";
	}
	
	// abstract method
	public abstract double calculatePolicyCharge(InsuredValue insuredValue);
	
	
	
}
