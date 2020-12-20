package cargoPackages;

import java.util.Calendar;

/*
 *This CargoPackage class is base class for other cargo types, its generic for cargo code
 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public abstract  class CargoPackage<T> implements ICargoPackage<T>,INumeric{

	private int weight;
	private int width;
	private int length;
	private int height;
	private T cargoCode;
	
	
	public CargoPackage() {
		this(null,0,0,0,0);
	}
	public CargoPackage( T cargoCode, int weight, int width, int lenght, int height) {
		this.cargoCode = cargoCode;
		this.weight = weight;
		this.width = width;
		this.length = lenght;
		this.height = height;
	}
	
	
	// we do not have have any set method, because we do not want that someone change the values
	public int getWeight() {
		return weight;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public int getHeight() {
		return height;
	}
	
	public T getCargoCode() {
		return cargoCode;
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public DayOfWeek calculateDeliveryDay() {
        Calendar calendar = Calendar.getInstance();
        int shipmentDuration = 2 ;
        switch((calendar.getTime().getDay() + shipmentDuration - 1) % 6 ) { // Since getDay () code assumes 0 on Sunday,    
        case 0:															    // we subtracted 1 from the transaction.
            return DayOfWeek.MONDAY;										// Since Sunday is accepted as a holiday,
        case 1:																// we chose 6 the modular space.
            return DayOfWeek.TUESDAY;
        case 2:
            return DayOfWeek.WEDNESDAY;
        case 3:
            return DayOfWeek.THURSDAY;
        case 4:
            return DayOfWeek.FRIDAY;
        case 5:
            return DayOfWeek.SATURDAY;
        default:
            return null; //Not necessary throws an exception because all possibilities has controlled
        }
    }
	


	@Override
	public int calculateSize() {
		double desi = (double)(this.width*this.length*this.height)/3000;
		return (int) Double.max(desi,Double.valueOf(weight));
	}
	// it is used for checking code format whether is numeric or not
	public boolean isNumeric(Object object) { 
	  try {  
		    Double.parseDouble(object.toString());  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	

	
}
