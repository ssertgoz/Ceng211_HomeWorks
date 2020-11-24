package insurance;

import insuredValue.InsuredValue;

/*
 *  This is Traffic class that extends Insurance class.
 *  It has three constructor.
 *  and there is a calculatePolicyCharge method to calculate
 *  charge for Traffic insurance.
 *  
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */
public class Traffic extends Insurance{
	
	// Constructor for random fixed fee between 1000 and 3000
	public Traffic() {
		this(getRandomFixedFee());
	}
	// Constructor for fixed fee between 1000 and 3000
	public Traffic(int fixedFee) {
		this(fixedFee,false);
	}
	// Constructor for any fee
	public Traffic(int fixedFee, boolean anyFee) {
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
			policyCharge = ((0.9)*getFixedFee()) + getFixedFee()*Math.pow(insuredValue.calculateRiskFactor(),0.5);			
		}
		if (rank > 1) {
			policyCharge -= policyCharge*(0.2);
		}
		
		return policyCharge;
	}
	
}

