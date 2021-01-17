package fileAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* This CSVFileAccess class is used to read and write csv files
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class CSVFileAccess implements ICSVFileAccess {
	
	private String line;
	private String fileName;
	
	public CSVFileAccess(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public boolean writeToFile(String content) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.write(content);
			fileWriter.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("An error occurred while file is written");
			return false;
		}

	}

	@Override
	public ArrayList<String> readFile() {
		ArrayList<String> lines = new ArrayList<String>();
		
        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            while((line = br.readLine())!= null) {
            	lines.add(line);
            }
            br.close();

        }catch(FileNotFoundException exception){
            System.out.println("File not found");
        }catch(IOException exception) {
            System.out.println(exception);
        }

		return lines;
	}


	
	

}
