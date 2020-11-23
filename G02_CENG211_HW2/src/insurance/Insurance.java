package insurance;

import insuredValue.InsuredValue;

/**   
 * This is our Insurance class where has the main method.
 * So program starts from here and creates an InsurancePolicyChargeCalculatorAppView class 
 * then get user input to to show the policy charge lists
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
	
	public abstract double calculatePolicyCharge(InsuredValue insuredValue);
	
	
	
}
