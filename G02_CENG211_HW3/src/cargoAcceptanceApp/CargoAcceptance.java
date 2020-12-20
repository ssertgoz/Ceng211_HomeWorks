package cargoAcceptanceApp;

import java.util.ArrayList;
import java.util.HashMap;
import cargoPackages.ECommerceCargoPackage;
import cargoPackages.NormalCargoPackage;
import exceptions.CargoTypeNotSupportedException;
import fileAccess.CSVReader;
import fileAccess.IFileIO;

/*
 *This CargoAcceptance class call FileIO class to get string values of cargo packages
 *and add them to an ArrayList according to their type. We will use this ArrayList
 *in the CargoAcceptanceAppView class for printing 
 *It has only one method
 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public class CargoAcceptance {
	
	public ArrayList<Object>  getCargoPackages() {
		
		ArrayList<Object> allCargoPackages = new ArrayList<Object>();
		IFileIO lines = new CSVReader(CargoAcceptanceApp.FILE_NAME);
		// We use this HashMap to store number of cargo packages for each site.
		// we use that number to check whether it is exceed the daily limit or not
		// Also we can store new in coming e-commerce sites so it is independent from sites number
		HashMap<String, Integer> dailyLimintCounterForSites = new HashMap<String, Integer>();
		
		for( String line : lines.getLines()) {
			try {
				String[] sp = line.split(";");
				
				if(sp[0].equals("Normal")) {
					allCargoPackages.add(new NormalCargoPackage(Long.parseLong(sp[1]),sp[2],sp[3],sp[4],Integer.parseInt(sp[5]),Integer.parseInt(sp[6]),Integer.parseInt(sp[7]),Integer.parseInt(sp[8])));
				}
				else if(sp[0].equals("Ecommerce")) {
					Object cargoCode = sp[2];
					// we count for each e-commerce site
					int counter = 1;
					if(dailyLimintCounterForSites.containsKey(sp[1])) {
						counter += dailyLimintCounterForSites.get(sp[1]).intValue();
						dailyLimintCounterForSites.put(sp[1], counter );
					}
					else {
						dailyLimintCounterForSites.put(sp[1], counter );
					}
					
					allCargoPackages.add(new ECommerceCargoPackage<Object>(sp[1],cargoCode,Integer.parseInt(sp[3]),Integer.parseInt(sp[4]),Integer.parseInt(sp[5]),Integer.parseInt(sp[6]),counter));
				}
				else {
					throw new CargoTypeNotSupportedException("Cargo type not supported!!");
				}
			}
			catch (CargoTypeNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return allCargoPackages;
		
	}
	
		

}
