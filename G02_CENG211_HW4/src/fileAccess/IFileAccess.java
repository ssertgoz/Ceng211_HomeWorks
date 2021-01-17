package fileAccess;

import java.util.ArrayList;

/* All file access classes should implement this interface
 * 
 * @author  Serdar Sertg�z  260201030
 * @author  Ertu�rul Demir  260201059
 */
public interface IFileAccess {
	
	public boolean writeToFile(String content);
	public ArrayList<String> readFile();
	

}
