package insuredValue;

import riskFactorValues.RiskFactorValues;

/*
 *  This is Person class that extends InsuredValue class.
 *  It has two constructor.
 *  and there is a calculateRiskFactor method to calculate
 *  risk factor according to risk factor values.
 *  
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Person extends InsuredValue {
	
	private String residenceCity;
	private String name;
	private double nationalID;
	private String gender;
	private int yearOfBirth;
	private String typeOfIllness;
	private int age;
	private boolean initialized;
	
	// Constructors
	public Person() {
		this("Unknown",1923,"Unknown","Unknown",1000000000,"Unknown",1923,"Unknown");
	}
	public Person(String insuranceNumber, int yearOfInsurance,String residenceCity, String name, double nationalID, String gender, int yearOfBirth, String typeOfIllness) {
		super(insuranceNumber, yearOfInsurance);
		
		if((residenceCity != null) && (name != null) && (nationalID > 0) && ((gender.equals("female") || gender.equals("male"))) && (yearOfBirth >= 1923) && (typeOfIllness != null)) {
			this.residenceCity = residenceCity;
			this.name = name;
			this.nationalID = nationalID;
			this.gender = gender;
			this.yearOfBirth = yearOfBirth;
			this.typeOfIllness = typeOfIllness;
			this.age = 2020 - yearOfBirth;
			this.initialized = true;
		}
		else {
			System.out.println("Invalid entries for Person !!");
		}
	}
	
	// Getter and Setters
	public String getResidenceCity() {
		return residenceCity;
	}
	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getNationalID() {
		return nationalID;
	}
	public void setNationalID(int nationalID) {
		this.nationalID = nationalID;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public String getTypeOfIllness() {
		return typeOfIllness;
	}
	public void setTypeOfIllness(String typeOfIllness) {
		this.typeOfIllness = typeOfIllness;
	}
	
	@Override
	public String toString() {
		return "Insured value : Person " + super.toString();
	}
	
	
	public double calculateRiskFactor() {
		RiskFactorValues rfv = new RiskFactorValues(); // Help us to get risk factor values
		double riskFactor = -1;
		if (initialized) {
			riskFactor = Math.pow(age,2)/(rfv.getTypeOfChronicleIllnessRiskFactorValue(getTypeOfIllness())*18);
		}
		return riskFactor;
	}
}
