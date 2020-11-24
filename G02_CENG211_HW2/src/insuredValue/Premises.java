package insuredValue;


/*
*  This is Premises class that extends InsuredValue class.
*  It has two constructor and getters, setters
*  
* @author  Serdar Sertgöz  260201030
* @author  Ertuðrul Demir  260201059
*/

public abstract class Premises extends InsuredValue {
	private String premisesCity;
	private int numberOfFloors;
	private int yearOfConstruction;
	private String typeOfConstruction;
	private double surfaceArea;
	
	// Constructors
	public Premises() {
		this("N0000",1923,"Unknown",1,1923,"Unknown",1);
	}
	public Premises( String insuranceNumber, int yearOfInsurance, String premisesCity, int numberOfFloors, int yearOfConstruction,String typeOfConstruction, double surfaceArae) {
		super(insuranceNumber,yearOfInsurance);
		if ((premisesCity != null) && (numberOfFloors > 0) && (yearOfConstruction >= 1923) && (surfaceArae > 0)) {
			this.premisesCity = premisesCity;
			this.numberOfFloors = numberOfFloors;
			this.yearOfConstruction = yearOfConstruction;
			this.typeOfConstruction = typeOfConstruction;
			this.surfaceArea = surfaceArae;
		}
		else {
			System.out.println("Invalid entries for premises !!");
		}
	}
	
	
	// Getters and Setters
	public String getPremisesCity() {
		return premisesCity;
	}
	public void setPremisesCity(String premisesCity) {
		this.premisesCity = premisesCity;
	}
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	public int getYearOfConstruction() {
		return yearOfConstruction;
	}
	public void setYearOfConstruction(int yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}
	public String getTypeOfConstruction() {
		return typeOfConstruction;
	}
	public void setTypeOfConstruction(String typeOfConstruction) {
		this.typeOfConstruction = typeOfConstruction;
	}
	public double getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
