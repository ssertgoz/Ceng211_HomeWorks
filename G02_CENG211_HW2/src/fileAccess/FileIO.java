package fileAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import insuredValue.Automobile;
import insuredValue.Housing;
import insuredValue.InsuredValue;
import insuredValue.Person;
import insuredValue.Truck;
import insuredValue.Workplace;

/*
 *  This is FileIO class that reads file and add all InsuredValue Objects to an ArrayList
 *  Hi
 *  Im here
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class FileIO {
	
	
	public ArrayList<InsuredValue> getInsuredValueList() throws IOException{
			ArrayList<InsuredValue> insuredValueArrayList = new ArrayList<InsuredValue>();
		try {
			BufferedReader insuredValues_br = new BufferedReader(new FileReader(String.format("HW2_InsuredValues.csv")));
			String line ;
			ArrayList<String> lineArrayList = new ArrayList<String>();
			while((line = insuredValues_br.readLine()) != null) {
				lineArrayList.add(line);
			}
			insuredValues_br.close();
			int lengthArray = lineArrayList.size();
			for (int i = 0 ; i < lengthArray ; i++ ) {
				String[] materialOfLineArray = lineArrayList.get(i).split(",");
				switch (String.valueOf(materialOfLineArray[0].charAt(0))) {     //Checking what type of insured it is
				case ("A"):{
					Automobile automobile = new Automobile(materialOfLineArray[0],Integer.parseInt(materialOfLineArray[1]),materialOfLineArray[2],Double.parseDouble(materialOfLineArray[3]),Integer.parseInt(materialOfLineArray[4]),materialOfLineArray[5],Integer.parseInt(materialOfLineArray[6]),materialOfLineArray[7]);
					insuredValueArrayList.add(automobile);
					break;
				}
				case ("H"):{
					Housing housing = new Housing(materialOfLineArray[0],Integer.parseInt(materialOfLineArray[1]),materialOfLineArray[2],Integer.parseInt(materialOfLineArray[3]),Integer.parseInt(materialOfLineArray[4]),materialOfLineArray[5],Integer.parseInt(materialOfLineArray[6]),materialOfLineArray[7]);
					insuredValueArrayList.add(housing);
					break;
				}
				case ("P"):{
					Person person = new Person(materialOfLineArray[0],Integer.parseInt(materialOfLineArray[1]),materialOfLineArray[2],materialOfLineArray[3],Double.parseDouble(materialOfLineArray[4]),materialOfLineArray[5],Integer.parseInt(materialOfLineArray[6]),materialOfLineArray[7]);
					insuredValueArrayList.add(person);
					break;
				}
				case ("T"):{
					Truck truck = new Truck(materialOfLineArray[0],Integer.parseInt(materialOfLineArray[1]),materialOfLineArray[2],Double.parseDouble(materialOfLineArray[3]),Integer.parseInt(materialOfLineArray[4]),materialOfLineArray[5],Integer.parseInt(materialOfLineArray[6]),materialOfLineArray[7]);
					insuredValueArrayList.add(truck);
					break;
				}
				case ("W"):{
					Workplace workplace = new Workplace(materialOfLineArray[0],Integer.parseInt(materialOfLineArray[1]),materialOfLineArray[2],Integer.parseInt(materialOfLineArray[3]),Integer.parseInt(materialOfLineArray[4]),materialOfLineArray[5],Double.parseDouble(materialOfLineArray[6]),Integer.parseInt(materialOfLineArray[7]));
					insuredValueArrayList.add(workplace);
					break;
				}
				default:
					continue; //Give an Exception at the end of working
				}
			}
			return insuredValueArrayList;
		}
		catch(FileNotFoundException exception) {
			System.out.println("file not found"); }
		catch(IOException exception) {
			System.out.println(exception);
		}
		return insuredValueArrayList;
	}
	
	
	
	
}
