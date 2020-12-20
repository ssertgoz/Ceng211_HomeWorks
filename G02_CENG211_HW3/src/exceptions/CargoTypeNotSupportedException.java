package exceptions;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */


@SuppressWarnings("serial")
public class CargoTypeNotSupportedException extends Exception{
    public CargoTypeNotSupportedException(String message) {
        super(message);
    }
}
