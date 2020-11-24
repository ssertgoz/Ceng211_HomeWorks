package insurance;

import insuredValue.InsuredValue;

/*
 *  This is Health class that extends Insurance class.
 *  It has three constructor.
 *  and there is a calculatePolicyCharge method to calculate
 *  charge for health insurance.
 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Health extends Insurance{
	
	// Constructor for random fixed fee between 1000 and 3000
	public Health() {
		this(getRandomFixedFee());
	}
	// Constructor for fixed fee between 1000 and 3000
	public Health(int fixedFee) {
		this(fixedFee,false);
	}
	// Constructor for any fee
	public Health(int fixedFee, boolean anyFee) {
		if (anyFee) {
			setFixedFee(fixedFee);
		}
		else if(fixedFee >= 1000 && fixedFee <= 3000 ) {
			setFixedFee(fixedFee);
		}
		else {
			System.out.println("Invalid entry for fixed fee !! ");
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public double calculatePolicyCharge(InsuredValue insuredValue) {
		double policyCharge =  1000000000;              // it means insurance application is denied
		int rank = 2020 - insuredValue.getYearOfInsurance();
		
		if (rank < 3 && insuredValue.calculateRiskFactor() > 50) {
			return policyCharge;
		}
		else if(insuredValue.calculateRiskFactor() != -1) {
			policyCharge = getFixedFee()*Math.pow(insuredValue.calculateRiskFactor(),3)/208;			
		}
		return policyCharge;
	}
	
}
