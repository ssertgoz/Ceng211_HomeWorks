package insuredValue;

import riskFactorValues.RiskFactorValues;

public class Housing extends Premises{

	private String residentSituation;
	private boolean initialized;
	
	// Constructors
	public Housing () {
		this("N0000",1923,"Unknown",1,1923,"Unknown",1,"Unknown");
	}
	public Housing(String insuranceNumber, int yearOfInsurance,String premisesCity, int numberOfFloors, int yearOfConstruction, String typeOfConstruction, double surfaceArae, String residentSituation) {
		super(insuranceNumber, yearOfInsurance, premisesCity, numberOfFloors, yearOfConstruction,typeOfConstruction, surfaceArae);
		
		if (residentSituation != null) {
			this.residentSituation = residentSituation;
			this.initialized = true;
		}
		else {
			System.out.println("Invalid resident situation for housing !!");
		}
	}
	
	// Getters and Setters
	public String getResidentSituation() {
		return residentSituation;
	}
	public void setResidentSituation(String residentSituation) {
		this.residentSituation = residentSituation;
	}
	
	public String toString() {
		return "Insured value : Housing " + super.toString();
	}
	
	
	public double calculateRiskFactor() {
		RiskFactorValues rfv = new RiskFactorValues(); // Help us to get risk factor values
		double riskFactor = -1;
		if (initialized) {
			riskFactor = rfv.getPremisesCityRiskFactorValue(getPremisesCity())*rfv.getNumberOfFloorsRiskFactorValue(getNumberOfFloors());
			riskFactor *= rfv.getYearOfConstructionRiskFactorValue(getYearOfConstruction())*rfv.getTypeOfConstructionRiskFactorValue(getTypeOfConstruction());
			riskFactor = riskFactor*getSurfaceArea()/rfv.getResidentSituationRiskFactorValue(getResidentSituation());
		}
		return riskFactor;
	}
}
