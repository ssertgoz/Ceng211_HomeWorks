package insurancePolicyChargeCalculatorApp;

import insurance.Health;
import insurance.Household;
import insurance.Insurance;
import insurance.Traffic;
import insuredValue.InsuredValue;
import policyRecord.PolicyRecord;

/**   
 * This is our InsurancePolicyChargeCalculatorAppView class.
 * It has some methods to help to main program to show datas 
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class InsurancePolicyChargeCalculatorAppView {
	
	private PolicyRecord pr;
	
	public  InsurancePolicyChargeCalculatorAppView () {
		pr = new PolicyRecord(); // we can use all lists 
	}
	
	// display all work places on the screen
	private void showWorkplaces() {
		Household household;
		for (InsuredValue workPlace : pr.getWorkPlaceList()) {
			household = new Household();
			printing(workPlace, household);
		}
	}
	
	// display all housing on the screen
	private void showHousings() {
		Household household;
		for (InsuredValue housing : pr.getHousingList()) {
			household = new Household();
			printing(housing, household);
		}
	}
	
	// display all persons on the screen
	private void showPersons() {
		Health health;
		for (InsuredValue person : pr.getPersonList()) {
			health = new Health();
			printing(person, health);
		}
	}
	
	// display all automobiles on the screen
	private void showAutomobiles() {
		Traffic traffic;
		for (InsuredValue automobile : pr.getAutomobileList()) {
			traffic = new Traffic();
			printing(automobile, traffic);
		}
	}
	
	// display all trucks on the screen
	private void showTrucks() {
		Traffic traffic;
		for (InsuredValue truck : pr.getTruckList()) {
			traffic = new Traffic();
			printing(truck, traffic);
		}
	}
	
	// display the lists according to user input
	public void printLists(String userInput) {
		switch (userInput) {
		case "1":
			showWorkplaces();
			showHousings();
			showPersons();
			showAutomobiles();
			showTrucks();
			break;
		case "2":
			showWorkplaces();
			break;
		case "3":
			showHousings();
			break;
		case "4":
			showPersons();
			break;
		case "5":
			showAutomobiles();
			break;
		case "6":
			showTrucks();
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + userInput);
		}
	}
	
	// call the toString methods from insurance and insured value and then print them properly
	private void printing(InsuredValue insuredValue, Insurance insurance) {
		System.out.println("\n" + insuredValue.toString() + "\n" + insurance.toString() + String.format("%s : %f", insuredValue.getInsuranceNumber(), insurance.calculatePolicyCharge(insuredValue)));
	}
}
