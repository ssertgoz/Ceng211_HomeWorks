package fileAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * This Class read csv files and return lines as a ArrayList of strings 
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */


public class CSVReader implements IFileIO {
	private String line;
	private String fileName;
	
	public CSVReader(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
    public ArrayList<String> getLines(){
        ArrayList<String> cargosArray = new ArrayList<String>();;

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName+".csv"));

            while((line = br.readLine())!= null) {
                cargosArray.add(line);
            }
            br.close();

        }catch(FileNotFoundException exception){
            System.out.println("Packages file not found");
        }catch(IOException exception) {
            System.out.println(exception);
        }

        return cargosArray;
	}

}
