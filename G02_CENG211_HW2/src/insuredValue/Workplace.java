package insuredValue;

import riskFactorValues.RiskFactorValues;

/*
 *  This is Workplace class that extends Premises class.
 *  It has two constructor, getters and setters
 *  and there is a calculateRiskFactor method to calculate
 *  risk factor according to risk factor values.
 *  
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Workplace extends Premises {
	
	private int annualRevenue;
	private boolean initialized;
	
	// Constructors
	public Workplace () {
		this("N0000",1923,"Unknown",1,1923,"Unknown",1,1);
	}
	public Workplace(String insuranceNumber, int yearOfInsurance, String premisesCity, int numberOfFloors, int yearOfConstruction,String typeOfConstruction, double surfaceArae, int annualRevenue) {
		super(insuranceNumber, yearOfInsurance, premisesCity, numberOfFloors, yearOfConstruction,typeOfConstruction, surfaceArae);
		if (annualRevenue > 0) {
			this.annualRevenue = annualRevenue;
			this.initialized = true;
		}
		else {
			System.out.println("Invalid revenue for workplace !!");
		}
	}
	
	// Getter and Setter
	public int getAnnualRevenue() {
		return annualRevenue;
	}
	public void setAnnualRevenue(int annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	
	public String toString() {
		return "Insured value : Workplace " + super.toString();
	}
	
	public double calculateRiskFactor() {
		RiskFactorValues rfv = new RiskFactorValues(); // Help us to get risk factor values
		double riskFactor = -1;
		if (initialized) {
			riskFactor = rfv.getPremisesCityRiskFactorValue(getPremisesCity())*rfv.getNumberOfFloorsRiskFactorValue(getNumberOfFloors());
			riskFactor *= rfv.getYearOfConstructionRiskFactorValue(getYearOfConstruction())*rfv.getTypeOfConstructionRiskFactorValue(getTypeOfConstruction());
			riskFactor *= getSurfaceArea()*(0.2)*getAnnualRevenue()*(0.003);
		}
		return riskFactor;
	}
	
}
