package eCommerceSitres;

import exceptions.CargoCodeFormatException;
/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */


public class Amazon extends ECommerceSites implements IECommerceSites<Object>{
	
	public Amazon () {
		dailyLimit = 5;
	}
	
	@Override
	public void checkCodeFormat(Object cargoCode) throws CargoCodeFormatException {
		if(((cargoCode.toString().length() != 7) || !isNumeric(cargoCode))) {
			throw new CargoCodeFormatException("Code format is wrong for Amazon");
		}
	}
	
	public int getDailyLimit() {
		return this.dailyLimit;
	}

}
