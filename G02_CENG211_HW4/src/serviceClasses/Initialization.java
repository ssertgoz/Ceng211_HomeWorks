package serviceClasses;

import java.util.ArrayList;
import complaint.Complaint;
import complaint.IComplaint;
import enums.Status;
import fileAccess.IFileAccess;
import product.IProduct;
import product.Product;
import users.Admin;
import users.Customer;
import users.IUser;
import users.Producer;


/* This class is used for initialize the values from file
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Initialization implements IInitialization{
	
	IFileAccess productFile;
	IFileAccess userFile;
	IFileAccess complaintFile;
	
	public Initialization(IFileAccess productFile,IFileAccess userFile,IFileAccess complaintFile) {
		this.productFile = productFile;
		this.userFile = userFile;
		this.complaintFile = complaintFile;
	}
	
	
	public ArrayList<IProduct> getProductArrayList(){
		ArrayList<IProduct> products = new ArrayList<IProduct>();
		ArrayList<String> lines = productFile.readFile();
		
		for(String line : lines) {
			String[] splitedLine = line.split(";");
			IProduct product = new Product(Integer.parseInt(splitedLine[0]), Integer.parseInt(splitedLine[1]), splitedLine[2], splitedLine[3]);
			products.add(product);
		}
		return products;
	}
	
	public ArrayList<IUser> getUserArrayList(){
		ArrayList<IUser> users = new ArrayList<IUser>();
		ArrayList<String> lines = userFile.readFile();
		
		for(String line : lines) {
			String[] splitedLine = line.split(";");
			if(splitedLine[4].equalsIgnoreCase("customer")) {
				users.add(new Customer(Integer.parseInt(splitedLine[0]),splitedLine[1],splitedLine[2],splitedLine[3]));
			}
			else if(splitedLine[4].equalsIgnoreCase("producer")) {
				users.add(new Producer(Integer.parseInt(splitedLine[0]),splitedLine[1],splitedLine[2],splitedLine[3]));
			}
			else {
				users.add(new Admin(Integer.parseInt(splitedLine[0]),splitedLine[1],splitedLine[2],splitedLine[3]));
			}
		}
		return users;
	}
	
	public ArrayList<IComplaint> getComplaintArrayList(){
		ArrayList<IComplaint> complaints = new ArrayList<IComplaint>();
		ArrayList<String> lines = complaintFile.readFile();
		
		for(String line : lines) {
			String[] splitedLine = line.split(";");
			IComplaint complaint = new Complaint(Integer.parseInt(splitedLine[0]),Integer.parseInt(splitedLine[1]),Integer.parseInt(splitedLine[2]),Integer.parseInt(splitedLine[3]),splitedLine[4],splitedLine[5],Status.valueOf(splitedLine[6]));
			complaints.add(complaint);
		}
		return complaints;
	}
	
	
	

}
