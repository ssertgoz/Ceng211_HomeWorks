package eCommerceSitres;

import exceptions.CargoCodeFormatException;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */


public class N11 extends ECommerceSites implements IECommerceSites<Object>{
	
	public N11() {
		dailyLimit = 6;
	}
	@Override
	public int getDailyLimit() {
		return this.dailyLimit;
	}

	@Override
	public void checkCodeFormat(Object cargoCode) throws CargoCodeFormatException {
		if(((cargoCode.toString().length() != 7) || isNumeric(cargoCode))) {
			throw new CargoCodeFormatException("Code format is wrong for N11");
		}
	}

}
