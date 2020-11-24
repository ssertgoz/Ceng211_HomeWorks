package insuredValue;

/*
*  This is Vehicle class that extends InsuredValue class.
*  It has two constructor. getters, setters.
* 
* @author  Serdar Sertgöz  260201030
* @author  Ertuðrul Demir  260201059
*/

public abstract class Vehicle extends InsuredValue {
	private String plateCity;
	private double engineVolume;
	private int yearOfProduction;
	private String typeOfGear;
	private int fuelTankVolume;
	
	// Constructors
	public Vehicle() {
		this("N0000",1923,"Unknown",1,1923,"Unknown",1);
	}
	public Vehicle(String insuranceNumber, int yearOfInsurance, String plateCity, double engineVolume, int yearOfProduction, String typeOfGear, int fuelTankVolume) {
		super(insuranceNumber, yearOfInsurance);
		
		if((plateCity != null) && (engineVolume > 0) && (yearOfProduction >= 1923) && (typeOfGear.equals("manual") || (typeOfGear.equals("automatic"))) && (fuelTankVolume > 0)) {
			this.plateCity = plateCity;
			this.engineVolume = engineVolume;
			this.yearOfProduction = yearOfProduction;
			this.typeOfGear = typeOfGear;
			this.fuelTankVolume = fuelTankVolume;
		}
		else {
			System.out.println("Invalid entries for Vehicle !!");
		}
	}
	
	// Getters and Setters
	public String getPlateCity() {
		return plateCity;
	}
	public void setPlateCity(String plateCity) {
		this.plateCity = plateCity;
	}
	public double getEngineVolume() {
		return engineVolume;
	}
	public void setEngineVolume(double engineVolume) {
		this.engineVolume = engineVolume;
	}
	public int getYearOfProduction() {
		return yearOfProduction;
	}
	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}
	public String getTypeOfGear() {
		return typeOfGear;
	}
	public void setTypeOfGear(String typeOfGear) {
		this.typeOfGear = typeOfGear;
	}
	public int getFuelTankVolume() {
		return fuelTankVolume;
	}
	public void setFuelTankVolume(int fuelTankVolume) {
		this.fuelTankVolume = fuelTankVolume;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
