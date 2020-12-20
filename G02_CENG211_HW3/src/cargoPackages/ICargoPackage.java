package cargoPackages;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */
public interface ICargoPackage<T> {
	int getWeight(); // return weight of cargo package
	int getWidth();	// return width of cargo package
	int getLength(); // return length of cargo package
	int getHeight(); // return height of cargo package
	T getCargoCode();// return cargo code of cargo package

	DayOfWeek calculateDeliveryDay(); // calculate delivery day
	int calculateSize(); // calculate size
}
