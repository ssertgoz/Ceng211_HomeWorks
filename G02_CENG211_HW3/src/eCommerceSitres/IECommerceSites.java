package eCommerceSitres;

import exceptions.CargoCodeFormatException;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public interface IECommerceSites<T> {
	void checkCodeFormat(T cargoCode) throws CargoCodeFormatException;
	public int getDailyLimit();
}
