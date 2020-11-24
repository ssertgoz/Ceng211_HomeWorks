package riskFactorValues;

/*
 *  This is RiskFactorValues class that implements RiskFactorValueIF.
 *  It has no constructor, getters and setters
 *  there are only some methods to get
 *  risk factor value according to datas
 *  
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public final class RiskFactorValues implements RiskFactorValueIF{
	
	 
	public  double getPremisesCityRiskFactorValue(String city) {
		double riskFactorValue = 0;	
		switch (city) {
		case "Izmir":
			riskFactorValue = 0.4;
			break;
		case "Istanbul":
			riskFactorValue = 0.6;
			break;
		case "Ankara":
			riskFactorValue = 0.15;
			break;
	
		default:
			riskFactorValue = 0.15;
		}
		return riskFactorValue;
	}
	
	public  double getNumberOfFloorsRiskFactorValue(int numberOfFloor) {
		double riskFactorValue = 0;
		if (numberOfFloor <= 3) {
			riskFactorValue = 0.1;
		}
		else if (numberOfFloor <= 7) {
			riskFactorValue = 0.25;
		}
		else if (numberOfFloor <= 18) {
			riskFactorValue = 0.5;
		}
		else {
			riskFactorValue = 0.85;
		}
		
		return riskFactorValue;
	}
	
	public  double getYearOfConstructionRiskFactorValue(int yearOfConstruction) {
		double riskFactorValue = 0;
		if (yearOfConstruction < 1975) {
			riskFactorValue = 0.58;
		}
		else if (yearOfConstruction <= 1999) {
			riskFactorValue = 0.32;
		}		
		else {
			riskFactorValue = 0.1;
		}
		
		return riskFactorValue;
	}
	
	public  double getTypeOfConstructionRiskFactorValue(String typeOfConstruction) {
		double riskFactorValue = 0;
		typeOfConstruction = typeOfConstruction.toLowerCase();
		switch (typeOfConstruction) {
		case "steel":
			riskFactorValue = 0.1;
			break;
		case "concrete":
			riskFactorValue = 0.37;
			break;
		case "wood":
			riskFactorValue = 0.58;
			break;
	
		default:
			riskFactorValue = 0.92;
		}
		return riskFactorValue;
	}

	public  double getResidentSituationRiskFactorValue(String residentSituation) {
		double riskFactorValue = 0;
		residentSituation = residentSituation.toLowerCase();
		switch (residentSituation) {
		case "tenant":
			riskFactorValue = 0.18;
			break;
		case "landlord":
			riskFactorValue = 0.42;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + residentSituation);
		}
		
		return riskFactorValue;
	}

	public  double getTypeOfChronicleIllnessRiskFactorValue(String illness) {
		double riskFactorValue = 0;
		illness = illness.toLowerCase();
		switch (illness) {
		case "cardiovascular":
			riskFactorValue = 1.85;
			break;
		case "diabetes":
			riskFactorValue = 1.84;
			break;
		case "respiratory":
			riskFactorValue = 1.86;
			break;
		case "none":
			riskFactorValue = 0.1;
			break;
		default:
			riskFactorValue = 1.8;
		}
		return riskFactorValue;
	}

	public  double getPlateCityRiskFactorValue(String city) {
		double riskFactorValue = 0;	
		switch (city) {
		case "Izmir":
			riskFactorValue = 0.78;
			break;
		case "Istanbul":
			riskFactorValue = 0.97;
			break;
		case "Ankara":
			riskFactorValue = 0.85;
			break;
	
		default:
			riskFactorValue = 0.65;
		}
		return riskFactorValue;
	}
	
	public  double getTypeOfGearRiskFactorValue(String gear) {
		double riskFactorValue = 0;
		gear = gear.toLowerCase();
		switch (gear) {
		case "manual":
			riskFactorValue = 0.47;
			break;
		case "automatic":
			riskFactorValue = 0.98;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + gear);
		}
		
		return riskFactorValue;
	}
	
	public  double getTypeOfRoofRiskFactorValue(String roof) {
		double riskFactorValue = 0;
		roof = roof.toLowerCase();
		switch (roof) {
		case "regular":
			riskFactorValue = 0.1;
			break;
		case "sunroof":
			riskFactorValue = 0.64;
			break;
		case "moonroof":
			riskFactorValue = 0.48;
			break;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + roof);
		}
		return riskFactorValue;
	}

	public  double getTypeOfTruckBedRiskFactorValue(String truckBed) {
		double riskFactorValue = 0;
		truckBed = truckBed.toLowerCase();
		switch (truckBed) {
		case "trailer":
			riskFactorValue = 0.87;
			break;
		case "tanker":
			riskFactorValue = 0.84;
			break;
		case "regular":
			riskFactorValue = 0.15;
			break;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + truckBed);
		}
		return riskFactorValue;
	}

}
