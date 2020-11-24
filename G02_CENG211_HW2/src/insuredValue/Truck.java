package insuredValue;

import riskFactorValues.RiskFactorValues;

/*
 *  This is Truck class that extends Vehicle class.
 *  It has two constructor, getters and setters
 *  and there is a calculateRiskFactor method to calculate
 *  risk factor according to risk factor values.
 *  
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Truck extends Vehicle {
	
	private String typeOfTruckBed;
	private int age;
	private boolean initialized;
	
	// Constructors
	public Truck() {
		this("N0000",1923,"Unknown",1,1923,"Unknown",1,"Unknown");
	}
	public Truck(String insuranceNumber, int yearOfInsurance, String plateCity, double engineVolume, int yearOfProduction, String typeOfGear, int fuelTankVolume,String typeOfTruckBed) {
		super(insuranceNumber, yearOfInsurance, plateCity, engineVolume, yearOfProduction, typeOfGear, fuelTankVolume);
		
		if(typeOfTruckBed != null) {
			this.typeOfTruckBed = typeOfTruckBed;
			this.age = 2020-yearOfProduction;
			initialized = true;
		}
		else {
			initialized = false;
			System.out.println("Invalid type of truck bed for Truck !!");
		}
	}
	
	// Getter and Setter
	public String getTypeOfTruckBed() {
		return typeOfTruckBed;
	}
	public void setTypeOfTruckBed(String typeOfTruckBed) {
		this.typeOfTruckBed = typeOfTruckBed;
	}
	
	@Override
	public String toString() {
		return "Insured value : Truck " + super.toString();
	}
	
	public double calculateRiskFactor() {
		RiskFactorValues rfv = new RiskFactorValues(); // Help us to get risk factor values
		double riskFactor = -1;
		if (initialized) {
			riskFactor = (((Math.pow(age, 3)/(0.008*getFuelTankVolume()))*getEngineVolume()*(rfv.getPlateCityRiskFactorValue(getPlateCity())*0.03)))/Math.pow((rfv.getTypeOfTruckBedRiskFactorValue(getTypeOfTruckBed())),2);
		}
		return riskFactor;
	}
	
}
