package policyRecord;


import java.util.ArrayList;

import fileAccess.FileIO;
import insuredValue.InsuredValue;
import insuredValue.Person;
import insuredValue.Truck;
import insuredValue.Workplace;
import insuredValue.Automobile;
import insuredValue.Housing;
public class PolicyRecord {
	private FileIO fileIO;
	private ArrayList<InsuredValue> insuredValueList;
	public PolicyRecord() {
		try {
			fileIO = new FileIO();
			insuredValueList = fileIO.getInsuredValueList();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	public ArrayList<InsuredValue> getInsuredValueList() {
		return insuredValueList;
	}
	
	public ArrayList<InsuredValue> getAutomobileList(){
		ArrayList<InsuredValue> automobileList = new ArrayList<InsuredValue>();
		for (int i = 0 ; i < getInsuredValueList().size(); i++) {
			if (getInsuredValueList().get(i).getClass().equals(Automobile.class)) {
				automobileList.add(getInsuredValueList().get(i));
			}
		}
		return automobileList;
	}
	
	public ArrayList<InsuredValue> getHousingList(){
		ArrayList<InsuredValue> housingList = new ArrayList<InsuredValue>();
		for (int i = 0 ; i < getInsuredValueList().size();i++) {
			if (getInsuredValueList().get(i).getClass().equals(Housing.class)) {
				housingList.add(getInsuredValueList().get(i));
			}
		}
		return housingList;
	}
	
	public ArrayList<InsuredValue> getPersonList(){
		ArrayList<InsuredValue> personList = new ArrayList<InsuredValue>();
		for (int i = 0 ; i < getInsuredValueList().size();i++) {
			if (getInsuredValueList().get(i).getClass().equals(Person.class)) {
				personList.add(getInsuredValueList().get(i));
			}
		}
		
		return personList;
	}
	
	public ArrayList<InsuredValue> getTruckList(){
		ArrayList<InsuredValue> truckList = new ArrayList<InsuredValue>();
		for (int i = 0 ; i < getInsuredValueList().size();i++) {
			if (getInsuredValueList().get(i).getClass().equals(Truck.class)) {
				truckList.add(getInsuredValueList().get(i));
			}
		}
		return truckList;
	}
	
	public ArrayList<InsuredValue> getWorkPlaceList(){
		ArrayList<InsuredValue> workPlaceList = new ArrayList<InsuredValue>();
		for(int i = 0 ; i < getInsuredValueList().size();i++) {
			if (getInsuredValueList().get(i).getClass().equals(Workplace.class)) {
				workPlaceList.add(getInsuredValueList().get(i));
			}
		}
		return workPlaceList;
	}
	
	
	
}