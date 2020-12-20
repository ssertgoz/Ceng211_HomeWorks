package cargoPackages;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public interface IECommerceCargoPackage<T> extends ICargoPackage<T> {
	String getSiteName();
	String setStatus(T cargoCode, int count); // set status according to cargo code and count
	String getStatus();
}
