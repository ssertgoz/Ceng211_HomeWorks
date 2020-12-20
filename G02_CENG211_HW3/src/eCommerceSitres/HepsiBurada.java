package eCommerceSitres;

import exceptions.CargoCodeFormatException;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */


public class HepsiBurada extends ECommerceSites implements IECommerceSites<Object>{
	
	public HepsiBurada() {
		dailyLimit = 7;
	}
	
	@Override
	public void checkCodeFormat(Object cargoCode) throws CargoCodeFormatException {
		if(((cargoCode.toString().length() != 8) || isNumeric(cargoCode))) {
			throw new CargoCodeFormatException("Code format is wrong for Hepsiburada");
		}
	}

	@Override
	public int getDailyLimit() {
		return this.dailyLimit;
	}


}
