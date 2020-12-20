package eCommerceSitres;

import cargoPackages.INumeric;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public abstract class ECommerceSites implements INumeric {
	public int dailyLimit ;
	
	public boolean isNumeric(Object object) { 
		  try {  
			    Double.parseDouble(object.toString());  
			    return true;
			  } catch(NumberFormatException e){  
			    return false;  
			  }  
			}
}
