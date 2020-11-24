package riskFactorValues;

/* 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public interface RiskFactorValueIF {
	public  double getPremisesCityRiskFactorValue(String city);
	public  double getNumberOfFloorsRiskFactorValue(int numberOfFloor);
	public  double getYearOfConstructionRiskFactorValue(int yearOfConstruction);
	public  double getTypeOfConstructionRiskFactorValue(String typeOfConstruction);
	public  double getResidentSituationRiskFactorValue(String residentSituation);
	public  double getTypeOfChronicleIllnessRiskFactorValue(String illness);
	public  double getPlateCityRiskFactorValue(String city);
	public  double getTypeOfGearRiskFactorValue(String gear);
	public  double getTypeOfRoofRiskFactorValue(String roof);
	public  double getTypeOfTruckBedRiskFactorValue(String truckBed);
}
