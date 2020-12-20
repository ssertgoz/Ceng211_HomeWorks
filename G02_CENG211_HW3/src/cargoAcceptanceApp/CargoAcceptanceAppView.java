package cargoAcceptanceApp;

import cargoPackages.IECommerceCargoPackage;
import cargoPackages.INormalCargoPackage;
import exceptions.CargoTypeNotSupportedException;

/*
 *This CargoAcceptanceAppView class for construct the view for printing
 *We have methods for each cargo type, if added new types, we should add method for it
 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public class CargoAcceptanceAppView {
	CargoAcceptance cargoPackages = new CargoAcceptance();
	
	// build main page
	public void viewBuilder() {
		int numberOfAcceptedCargo = getNumberOfAcceptedCargo();
		System.out.println("Welcome!!");
		System.out.println("Number of Accepted Cargo: " + numberOfAcceptedCargo);
		System.out.println("Number of Not Accepted Cargo: " + (cargoPackages.getCargoPackages().size() - numberOfAcceptedCargo));
		System.out.println("Here are the details : \n");
		System.out.println("NORMAL CARGO PACKAGES : ");
		System.out.println("No  Cargo Code  Sender ID     Sender Name      Recipient Name   Recipient Address                Size  Price  Delivery Day");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.println(normalStringBuilder());
		System.out.println("\nE-COMMERCE CARGO PARCKAGES:");
		System.out.println("No  E-commerce Site  Cargo Code      Status         Size   Delivery Day");
		System.out.println("------------------------------------------------------------------");
		System.out.println(eCommerceStringBuilder());
		
		
	}
	
	// build string for eCommerce Sites
	@SuppressWarnings("unused")
	private String eCommerceStringBuilder() {
		String eCommerceCargoString = "";
		int counter = 1;
		
		for(Object cargoPackage : cargoPackages.getCargoPackages()) {
			try {
				@SuppressWarnings("unchecked")
				IECommerceCargoPackage<Object> eComerce = ((IECommerceCargoPackage<Object>)cargoPackage);
				eCommerceCargoString += String.format("%-2d  %-15s  %-13s  %-15s  %-5d  %-1s \n", counter,eComerce.getSiteName(),eComerce.getCargoCode().toString(),eComerce.getStatus(),eComerce.calculateSize(),eComerce.calculateDeliveryDay());
				counter += 1;
				
			} catch (ClassCastException e) {
				//we ignore other cargo types to get only e-commerce type
			}	
		}
		return eCommerceCargoString;
	}
	// build string for normal cargos
	@SuppressWarnings("unused")
	private String normalStringBuilder() {
		String normalCargoString = "";
		int counter = 1;
		
		for(Object cargoPackage : cargoPackages.getCargoPackages()) {
			try {
				INormalCargoPackage normal = (INormalCargoPackage)cargoPackage;
				normalCargoString += String.format("%-1d    %-9d  %-12d  %-15s  %-15s  %-31s  %-4d  %-5.2f  %-10s \n",counter,normal.getCargoCode().intValue(),normal.getSenderId(),normal.getSenderName(),normal.getRecipientName(),normal.getRecipientAddress(),normal.calculateSize(),normal.calculatePrice(),normal.calculateDeliveryDay());
				counter += 1;
				
			} catch (ClassCastException e) {
				//we ignore other cargo types to get only normal type
			}	
		}
		return normalCargoString;
	}
	
	// we get number of accepted cargos and we can calculate not accepted cargos by subtracting from total cargo number
	@SuppressWarnings("unchecked")
	private int getNumberOfAcceptedCargo () {
		int numberOfAcceptedCargo = 0;
		
		for(Object cargoPackage : cargoPackages.getCargoPackages()) {
			try {
				INormalCargoPackage normal = (INormalCargoPackage)cargoPackage;
				if(normal.getStatus().equals("Accepted")) {
					numberOfAcceptedCargo += 1;
				}
				
			} catch (ClassCastException e) {
				try {				
					try {
						IECommerceCargoPackage<Object> eComerce = ((IECommerceCargoPackage<Object>)cargoPackage);
						if(eComerce.getStatus().equals("Accepted")) {
							numberOfAcceptedCargo += 1;
							}
						} 
					catch (ClassCastException e2) {
						throw new CargoTypeNotSupportedException("Cargo type not Supported for now by the code!!");
						}
					
				} catch (CargoTypeNotSupportedException e2) {
					System.out.println(e.getMessage());
				}



			}	
		}
		return numberOfAcceptedCargo;
	}
}
