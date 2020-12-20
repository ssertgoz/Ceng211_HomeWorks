package fileAccess;

import java.util.ArrayList;

/*
 * All file reader class implements this interface
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public interface IFileIO {
	public ArrayList<String> getLines(); // return ArrayList of string of lines
}
