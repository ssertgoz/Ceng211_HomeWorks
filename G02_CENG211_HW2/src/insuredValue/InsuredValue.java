package insuredValue;

/*
 *  This is InsuredValue base class.
 *  It has three constructor, getters and setters
 *  and there is an abstract calculateRiskFactor
 *  
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public abstract class InsuredValue {
	private String insuranceNumber;
	private int yearOfInsurance;
	
	
	// Constructors
	public InsuredValue () {
		this("N0000",1923);
	}
	public InsuredValue (String insuranceNumber) {
		if ((insuranceNumber != null) && (insuranceNumber.length() == 5)) {
			this.insuranceNumber = insuranceNumber;
		}
		else {
			System.out.println("Insurance number is not valid !!");
		}
		
	}
	public InsuredValue (String insuranceNumber, int yearOfInsurance) {
		this(insuranceNumber);
		if (yearOfInsurance >= 1923) {
			this.yearOfInsurance = yearOfInsurance;
		}
		else {
			System.out.println("Year of insurance is not valid !!");
		}
		
	}
	
	// Getters and Setters
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	public int getYearOfInsurance() {
		return yearOfInsurance;
	}
	public void setYearOfInsurance(int yearOfInsurance) {
		this.yearOfInsurance = yearOfInsurance;
	}
	
	@Override
	public String toString() {
		return String.format("insurance number : %s  ----  Year of insurance : %d", getInsuranceNumber(),getYearOfInsurance());
	}
	
	public abstract double calculateRiskFactor();
}
