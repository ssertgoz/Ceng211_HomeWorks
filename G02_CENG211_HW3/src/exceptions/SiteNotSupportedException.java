package exceptions;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */


@SuppressWarnings("serial")
public class SiteNotSupportedException extends Exception{
    public SiteNotSupportedException(String message) {
        super(message);
    }

}
