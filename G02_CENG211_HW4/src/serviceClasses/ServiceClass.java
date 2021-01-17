package serviceClasses;

import java.util.ArrayList;
import java.util.Scanner;
import app.CustomerComplaintApp;
import complaint.Complaint;
import complaint.IComplaint;
import drawings.Draw;
import enums.Status;
import enums.UserTypes;
import fileAccess.CSVFileAccess;
import fileAccess.IFileAccess;
import product.IProduct;
import product.Product;
import users.Customer;
import users.IUser;
import users.Producer;

/* This ServiceClass is use other classes to run the program as desired
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class ServiceClass {
	
	private IFileAccess productFile;
	private IFileAccess userFile;
	private IFileAccess complaintFile;
	private IInitialization initialization;
	private ArrayList<IProduct> productList;
	private ArrayList<IComplaint> complaintList;
	private ArrayList<IUser> userList;
	private IUser activeUser;
	private Draw draw;
	private Scanner input;
	
	public ServiceClass() {
		// get the files to read and write
		productFile = new CSVFileAccess(CustomerComplaintApp.PRODUCT_FILE_NAME);
		userFile = new CSVFileAccess(CustomerComplaintApp.USER_FILE_NAME);
		complaintFile = new CSVFileAccess(CustomerComplaintApp.COMPLAINT_FILE_NAME);
		// initialize the values
		initialization = new Initialization(productFile, userFile, complaintFile);
		// get array lists from initialization class
		productList = initialization.getProductArrayList();
		complaintList = initialization.getComplaintArrayList();
		userList = initialization.getUserArrayList();
		// get draw class to use drawing methods
		draw = new Draw();
		input = new Scanner(System.in);
		
	}
	
	
	// it runs the program
	public void run() {
		while(true) {
			activeUser = null;
			draw.firstPage();
			
			String selection = input.nextLine();
			if(selection.equals("1")) {
				activeUser = signUp();
			}
			else if(selection.equals("2")) {
				activeUser = logIn();
			}
			else if(selection.equals("e")) {break;}
			else {System.out.println("You enter wrong input !!");}
			// open pages according to user type unless active user is not null
			if(activeUser != null) {
				switch (activeUser.getUserType()) {
				case ADMIN:
					adminPage();
					break;
				case CUSTOMER:
					customerPage();
					break;
				case PRODUCER:
					producerPage();
					break;
				}
				
			}
		}
			
	}
	
	private IUser signUp() {
		IUser user;
		while(true) {
			try {
				draw.signUpPage();
				String signUpinput = input.nextLine();
				if(signUpinput.equalsIgnoreCase("p")){break;}
				
				String[] splitedLine = signUpinput.split(";");

				if(splitedLine[3].equalsIgnoreCase("customer")) {
					user = new Customer(splitedLine[0],splitedLine[1],splitedLine[2]);
				}
				else if(splitedLine[3].equalsIgnoreCase("producer")) {
					user = new Producer(splitedLine[0],splitedLine[1],splitedLine[2]);
				}
				// turn to beginning of the loop if producer or customer written wrong or not written
				else {
					draw.wrongEntry();
					continue;
				}
				if(splitedLine.length > 4) {
					draw.wrongEntry();
					continue;
				}
				ArrayList<String> lines = userFile.readFile();
				lines.add(String.format("%d;%s;%s;%s;%s",user.getUserId(),user.getUserName(),user.getPassword(),user.getDisplayedName(),user.getUserType().toString().toLowerCase()));
				if(userFile.writeToFile(buildStringToWrite(lines)) && user != null) {
					userList.add(user);
					System.out.println("Added successfully");
					return user;
				}

			} catch (IndexOutOfBoundsException e) {
				draw.wrongEntry();
			}
		}
		return null;
	}
	
	private IUser logIn() {
		while(true) {
			try {
				draw.logInPage();
				String logIninput = input.nextLine();
				if(logIninput.equalsIgnoreCase("p")){break;}
				String[] splittedLogInpinput = logIninput.split(";");
				
				if(splittedLogInpinput.length != 2) {
					draw.wrongEntry();
					continue;
				}
				for(IUser user: userList) {
					if(user.getUserName().equals(splittedLogInpinput[0]) & user.getPassword().equals(splittedLogInpinput[1]) ) {
						return user;
					}
				}
				System.out.println("User didnt sign-up before !!");
			} catch (NumberFormatException e) {
				draw.wrongEntry();
			}
		}
		return null;
	}
		
	
	private void producerPage() {
		while(true) {
			draw.producerPage(activeUser);
			String selection = input.nextLine();
			if(selection.equals("1")) {
				addProduct();
			}
			
			else if(selection.equals("2")) {
				seeRelatedComplaints();
			}
			else if (selection.equals("p")) {break;}
			else {draw.wrongEntry();}
		}		
	}
	
	private void customerPage() {
		while(true) {
			draw.customerPage(activeUser);
			String selection = input.nextLine();
			if(selection.equals("1")) {
				addComplaint();
			}
			
			else if(selection.equals("2")) {
				seePreviousComplaints();
			}
			else if (selection.equalsIgnoreCase("p")) {break;}
			else {draw.wrongEntry();}
		}
	}


	// it prints the all complaints directly
	private void adminPage() {
		draw.adminPage(activeUser);
		while(true) {
			try {
				// print the list of complaints
				for(IComplaint complaint :complaintList) {
					draw.complaintListForAdmin(complaint, getUserById(complaint.getCustomerId()),getUserById(complaint.getProducerId()), getProductById(complaint.getProductId()), complaintList.indexOf(complaint)+1);
				}
				System.out.print("Choose a complaint (type index of complaint, ex. 1,2...) or , go to previous page(p) : ");
				String selection = input.nextLine();
				if (selection.equals("p")) {break;}
				IComplaint complaint = complaintList.get(Integer.parseInt(selection)-1);
				draw.chosenComplaintForAdmin(complaint, getUserById(complaint.getCustomerId()),getUserById(complaint.getProducerId()), getProductById(complaint.getProductId()));
				
				selection = input.nextLine();
				
				if(selection.equalsIgnoreCase("w") && changeStatusOfComplaint(complaint, Status.WORKING)) {}
				else if(selection.equalsIgnoreCase("f") && changeStatusOfComplaint(complaint, Status.FIXED)) {}
				else if(selection.equalsIgnoreCase("n") && changeStatusOfComplaint(complaint, Status.NEW)) {}
				else if(selection.equalsIgnoreCase("s") && changeStatusOfComplaint(complaint, Status.SEEN)) {}
				else if(selection.equalsIgnoreCase("d") && changeStatusOfComplaint(complaint, Status.DELETED)) {}
				else if(selection.equalsIgnoreCase("p")) {break;}
				else {
					draw.statusErrorMessage();
					input.nextLine();
				}
			}
			catch (NumberFormatException e) {
				draw.wrongEntry();
			}
			catch (IndexOutOfBoundsException e) {
				draw.wrongEntry();
			}	
		}
	}


	// its for producer page
	private void seeRelatedComplaints() {
		while(true) {
			try {
				ArrayList<IComplaint> relatedComplaints = getComplaintsByProducerId(activeUser.getUserId());
				// print the list of complaints
				for(IComplaint complaint :relatedComplaints) {
					draw.complaintList(complaint, getUserById(complaint.getCustomerId()), getProductById(complaint.getProductId()), relatedComplaints.indexOf(complaint)+1);
				}
				System.out.print("Choose a complaint or go to previous page(p): ");
				String selection = input.nextLine();
				if(selection.equalsIgnoreCase("p")) {break;} // go to previous page
				
				System.out.println();
				IComplaint complaint = relatedComplaints.get(Integer.parseInt(selection)-1);
				if(complaint.getStatus() == Status.NEW) {changeStatusOfComplaint(complaint, Status.SEEN);}  // change status to seen when complaint was chosen
				draw.chosenComplaint(complaint, getUserById(complaint.getCustomerId()), getProductById(complaint.getProductId()));
				
				System.out.print("Chanege status of complaint; Working(w), Fixed(f)  or Previous Page(p) : ");
				selection = input.nextLine();
				if(selection.equalsIgnoreCase("p")) {break;}
				
				if(selection.equalsIgnoreCase("w") && changeStatusOfComplaint(complaint, Status.WORKING)) {
					draw.statusChangedMessage();
				}
				else if (selection.equalsIgnoreCase("f") && changeStatusOfComplaint(complaint, Status.FIXED)) {	
					draw.statusChangedMessage();
				}
				else {
					draw.statusErrorMessage();
				}
					
				input.nextLine();
			} catch (NumberFormatException e) {
				draw.wrongEntry();
			}catch (IndexOutOfBoundsException e) {
				draw.wrongEntry();
			}

		}
		
	}

	// its for producer to add product
	private void addProduct() {
		while(true) {
			try {
				String type;
				ArrayList<String> productTypes = getProductTypes();
				// this wile to add product type to list
				while(true) {
					try {
						draw.productTypeList(productTypes);
						System.out.print("or add new one (a) previous page(p): ");
						String selection = input.nextLine();	
						if(selection.equalsIgnoreCase("a")) {
							System.out.print("Write the type name : ");
							productTypes.add(input.nextLine());
						}
						else if(selection.equalsIgnoreCase("p")) {return;}
						else if(Integer.parseInt(selection)-1 > productTypes.size()) {continue;}
						else {
							type = productTypes.get(Integer.parseInt(selection)-1);
							break;
						}
					} catch (NumberFormatException e) {
						draw.wrongEntry();
					}

				}

				System.out.print("Enter the name of the product : ");
				String name = input.nextLine();
				IProduct product = new Product(activeUser.getUserId(),name,type);
				productList.add(product);
				ArrayList<String> lines = productFile.readFile();
				lines.add(String.format("%d;%d;%s;%s",product.getProductId(),activeUser.getUserId(),name,type));
				if(productFile.writeToFile(buildStringToWrite(lines))) {
					System.out.print("Added successfully !! press (p) to go to previous page : ");
				}
				else {
					System.out.print(" Couldnt Added !! press (p) to go to previous page : ");
				}
				
				input.nextLine();
				break;
			} catch (NumberFormatException e) {
				draw.wrongEntry();
			}catch (IndexOutOfBoundsException e) {
				draw.wrongEntry();
			}			
		}		
	}

	// its for customers to see their previous complaints
	private void seePreviousComplaints() {
		while(true) {
			try {
				ArrayList<IComplaint> relatedComplaints = getComplaintsByCustomerId(activeUser.getUserId());
				
				for(IComplaint complaint :relatedComplaints) {
					draw.complaintList(complaint, getUserById(complaint.getProducerId()), getProductById(complaint.getProductId()), relatedComplaints.indexOf(complaint)+1);
				}
				System.out.print("Choose a complaint or go to previous page(p): ");
				String selection = input.nextLine();
				if(selection.equalsIgnoreCase("p")) {break;}
				System.out.println();
				IComplaint complaint = relatedComplaints.get(Integer.parseInt(selection)-1);
				draw.chosenComplaint(complaint, getUserById(complaint.getProducerId()), getProductById(complaint.getProductId()));
				
				System.out.print("Delete(d)  or Previous Page(p) : ");
				selection = input.nextLine();
				if(selection.equalsIgnoreCase("d")) {
					if(complaint.getStatus() != Status.FIXED) {
						if(changeStatusOfComplaint(complaint, Status.DELETED)) {
							System.out.println("Deleted !!  press a key to go to previous page");
							input.nextLine();
						}
						else {
							draw.statusErrorMessage();
							input.nextLine();
						}
					}
					else {
						draw.statusErrorMessage();
						input.nextLine();
					}

				}
				if(selection.equalsIgnoreCase("p")) {break;}
				else {draw.wrongEntry();}
				
			} catch (NumberFormatException e) {
				draw.wrongEntry();
			}catch (IndexOutOfBoundsException e) {
				draw.wrongEntry();
			}

		}

	}
	
	// its for customers to add complaint
	private void addComplaint() {
		while(true) {
			try {
				ArrayList<IUser> producers = getUsersByType(UserTypes.PRODUCER);
				
				draw.userList(producers);
				String selection = input.nextLine();
				IUser producer = producers.get(Integer.parseInt(selection)-1);
				ArrayList<String> productTypes = getProductTypesByUserId(producer.getUserId());
				
				draw.productTypeList(productTypes);
				selection = input.nextLine();
				String productType = productTypes.get(Integer.parseInt(selection)-1);
				ArrayList<IProduct> products = getProductsByProducerIdAndType(producer.getUserId(),productType);
				
				draw.productList(products);
				selection = input.nextLine();
				IProduct product = products.get(Integer.parseInt(selection)-1);
				String[] complaintInfo;
				while(true) {
					draw.addComplintPage();
					complaintInfo = input.nextLine().split(";");
					if(complaintInfo.length != 2 ) {
						draw.wrongEntry();
						continue;
					}
					break;
				}
				
				IComplaint complaint = new Complaint(activeUser.getUserId(),producer.getUserId(),product.getProductId(),complaintInfo[0],complaintInfo[1]);
				ArrayList<String> lines = complaintFile.readFile();
				lines.add(String.format("%d;%d;%d;%d;%s;%s;%s",complaint.getComplaintId(),activeUser.getUserId(),producer.getUserId(),product.getProductId(),complaintInfo[0],complaintInfo[1],complaint.getStatus().toString()));
				if(complaintFile.writeToFile(buildStringToWrite(lines))) {
					System.out.println("Added successfully");
					complaintList.add(complaint);
					break;
				}
			} catch (NumberFormatException e) {
				draw.wrongEntry();
			}
			catch (IndexOutOfBoundsException e2) {
				draw.wrongEntry();
			}
		}


	}
	

		
	// change the status of the complaint and write it to file
	private boolean changeStatusOfComplaint(IComplaint complaint,Status newStatus) {
		ArrayList<String> lines = complaintFile.readFile();
		for(String line:lines) {
			if(Integer.parseInt(line.split(";")[0]) == complaint.getComplaintId()) {
				lines.remove(line);
				break;
			}
		}
		lines.add(String.format("%d;%d;%d;%d;%s;%s;%s",complaint.getComplaintId(),complaint.getCustomerId(),complaint.getProducerId(),complaint.getProductId(),complaint.getComplaintTitle(),complaint.getComplaint(),newStatus.toString()));
		if(complaintFile.writeToFile(buildStringToWrite(lines))) {
			complaint.setStatus(newStatus);
			return true;
		}
		return false;
	}
	
	private ArrayList<IProduct> getProductsByProducerIdAndType(int producerId,String productType){
		ArrayList<IProduct> productsByProducerId = new ArrayList<IProduct>();
		for(IProduct product : productList) {
			if(producerId == product.getProducerId() && productType.equalsIgnoreCase(productType)) {
				productsByProducerId.add(product);
			}
		}
		return productsByProducerId;	
	}
	
	private ArrayList<String> getProductTypesByUserId(int producerId){
		ArrayList<String> productsTypes = new ArrayList<String>();
		for(IProduct product : productList) {
			if(!productsTypes.contains(product.getProductType()) && product.getProducerId() == producerId) {
				productsTypes.add(product.getProductType());
			}
		}
		return productsTypes;	
	}
	
	private ArrayList<String> getProductTypes(){
		ArrayList<String> productsTypes = new ArrayList<String>();
		for(IProduct product : productList) {
			if(!productsTypes.contains(product.getProductType())) {
				productsTypes.add(product.getProductType());
			}
		}
		return productsTypes;	
	}
	
	
	private ArrayList<IUser> getUsersByType(UserTypes userType){
		ArrayList<IUser> usersByType = new ArrayList<IUser>();
		for(IUser user : userList) {
			if(userType == user.getUserType()) {
				usersByType.add(user);
			}
		}
		return usersByType;	
	}
	
	private ArrayList<IComplaint> getComplaintsByCustomerId(int customerId){
		ArrayList<IComplaint> complaintsByCustomerId = new ArrayList<IComplaint>();
		for(IComplaint complaint : complaintList) {
			if(customerId == complaint.getCustomerId() && complaint.getStatus() != Status.DELETED) {
				complaintsByCustomerId.add(complaint);
			}
		}
		return complaintsByCustomerId;	
	}
	
	
	private ArrayList<IComplaint> getComplaintsByProducerId(int producerId){
		ArrayList<IComplaint> complaintsProducerId = new ArrayList<IComplaint>();
		for(IComplaint complaint : complaintList ) {
			if(producerId == complaint.getProducerId()&& complaint.getStatus() != Status.DELETED) {
				complaintsProducerId.add(complaint);
			}
		}
		return complaintsProducerId;	
	}
	
	
	private IProduct getProductById(int productId) {
		for(IProduct product:productList){
			if(product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}
	
	private IUser getUserById(int userId) {
		for(IUser user : userList){
			if(user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}
	// build string from list of lines to write
	private String buildStringToWrite(ArrayList<String> listOfLines) {
		String content = "";
		for(String line : listOfLines) {
			content += (line+"\n");
		}
		return content;
	}
	

}
