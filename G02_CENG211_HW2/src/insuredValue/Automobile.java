package insuredValue;

import riskFactorValues.RiskFactorValues;

/*
 *  This is Automobile class that extends Vehicle class.
 *  It has two constructor, getters and setters
 *  and there is a calculateRiskFactor method to calculate
 *  risk factor according to risk factor values.
 *  
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Automobile extends Vehicle {

	private String typeOfRoof;
	private int age;
	private boolean initialized;
	
	// Constructors
	public Automobile() {
		this("N0000",1923,"Unknown",1,1923,"Unknown",1,"Unknown");		
	}
	public Automobile(String insuranceNumber, int yearOfInsurance, String plateCity, double engineVolume, int yearOfProduction, String typeOfGear, int fuelTankVolume, String typeOfRoof) {
		super(insuranceNumber, yearOfInsurance, plateCity, engineVolume, yearOfProduction, typeOfGear, fuelTankVolume);
		
		if(typeOfRoof != null) {
			this.typeOfRoof = typeOfRoof;
			this.age = 2020-yearOfProduction;
			initialized = true;
		}
		else {
			System.out.println("Invalid type of roof for Automobile");
		}
	}
	
	// Getter and Setter
	public String getTypeOfRoof() {
		return typeOfRoof;
	}
	public void setTypeOfRoof(String typeOfRoof) {
		this.typeOfRoof = typeOfRoof;
	}
	
	public String toString() {
		return "Insured value : Automobile " + super.toString();
	}
	
	public double calculateRiskFactor() {
		RiskFactorValues rfv = new RiskFactorValues(); // Help us to get risk factor values
		double riskFactor = -1;
		if (initialized) {
			riskFactor = (getEngineVolume()*(0.004*getFuelTankVolume())*age*(rfv.getPlateCityRiskFactorValue(getPlateCity())*0.03))/rfv.getTypeOfRoofRiskFactorValue(getTypeOfRoof());
		}
		return riskFactor;
	}
}
