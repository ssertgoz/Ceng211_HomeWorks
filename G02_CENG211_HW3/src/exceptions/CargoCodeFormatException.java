package exceptions;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

@SuppressWarnings("serial")
public class CargoCodeFormatException extends Exception{
    public CargoCodeFormatException(String message) {
        super(message);
    }
}
