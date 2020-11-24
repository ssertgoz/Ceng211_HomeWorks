package insurance;

import insuredValue.InsuredValue;


/*
 *  This is Household class that extends Insurance class.
 *  It has three constructor.
 *  and there is a calculatePolicyCharge method to calculate
 *  charge for Household insurance.
 *  
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Household extends Insurance{
	
	// Constructor for random fixed fee between 1000 and 3000
	public Household() {
		this(getRandomFixedFee());
	}
	// Constructor for fixed fee between 1000 and 3000
	public Household(int fixedFee) {
		this(fixedFee,false);
	}
	// Constructor for any fee
	public Household(int fixedFee, boolean anyFee) {
		if (anyFee) {
			setFixedFee(fixedFee);
		}
		else if(fixedFee >= 1000 && fixedFee <= 3000 ) {
			setFixedFee(fixedFee);
		}
		else {
			System.out.println("Invalid entry fro fixed fee !! ");
		}
	}
	
	public String toString() {
		return super.toString();
	}
	
	public double calculatePolicyCharge(InsuredValue insuredValue) {
		double policyCharge =  1000000000;              // it means insurance application is denied
		int rank = 2020 - insuredValue.getYearOfInsurance();
		if(insuredValue.calculateRiskFactor() != -1) {
			policyCharge = getFixedFee()*Math.pow(insuredValue.calculateRiskFactor(),2);			
		}
		if (rank > 2) {
			policyCharge -= policyCharge*(0.1);
		}
		return policyCharge;
	}
	
}
