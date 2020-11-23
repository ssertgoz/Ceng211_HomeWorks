package insurancePolicyChargeCalculatorApp;

import java.util.Scanner;

/**   
 * This is our InsurancePolicyChargeCalculatorApp where has the main method.
 * So program starts from here and creates an InsurancePolicyChargeCalculatorAppView class 
 * then get user input to to show the policy charge lists
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class InsurancePolicyChargeCalculatorApp {
	
	public static void main(String[] args) {
		boolean finished = false;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in); 
		InsurancePolicyChargeCalculatorAppView appView = new InsurancePolicyChargeCalculatorAppView();
		while(!finished) {
			System.out.println("\n---------------------------------------------------------------------------------------------------------------");
			System.out.println("1 - All insured values | 2 - Workplaces | 3 - Housings | 4 - Persons | 5 - Automobiles | 6 - Trucks | 7 - Exit");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.print("Enter a number : ");
			
			// you should enter proper number, if not it will rise an error
			String userInput = scan.nextLine();
		
			if(userInput.equals("7")) {
				System.out.println("Byeeee !!");
				finished = true;
			}
			else {
				appView.printLists(userInput);
			}
		}
	}
	
	

}
