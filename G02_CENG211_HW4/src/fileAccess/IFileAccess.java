package fileAccess;

import java.util.ArrayList;

/* All file access classes should implement this interface
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */
public interface IFileAccess {
	
	public boolean writeToFile(String content);
	public ArrayList<String> readFile();
	

}
