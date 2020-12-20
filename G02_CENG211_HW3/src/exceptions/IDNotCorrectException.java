package exceptions;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */


@SuppressWarnings("serial")
public class IDNotCorrectException extends Exception{
    public IDNotCorrectException(String message) {
        super(message);
    }
}
