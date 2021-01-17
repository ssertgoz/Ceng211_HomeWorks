package drawings;

import java.util.ArrayList;
import complaint.IComplaint;
import enums.UserTypes;
import product.IProduct;
import users.IUser;

/* This Draw class is used for to print some necessities and help to ServiceClass to print
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Draw {
	
	public void firstPage() {
		System.out.println("						WELCOME TO CUSTOMER COMPLAINT APP\n");
		System.out.println("							1- Sign-up");
		System.out.println("							2- Log-in\n");
		System.out.print("						Choose 1 or 2 , exit(e) : ");
		
	}
	
	public void signUpPage() {
		System.out.println("\n							      Sign-Up Page\n");
		System.out.println("						1- User Name : ");
		System.out.println("						2- Password : ");
		System.out.println("						3- Displayed Name : ");
		System.out.println("						4- User Type : ");
		System.out.println("\n You should enter this informations in a line with this order; 1,2... and put semicolon between them or , go to previous page(p) ");
		System.out.println("\n Ex : serdar;123456;sssss;customer or producer,  or go to previous page(p) ");
		System.out.print("Write : ");
		
	}
	
	public void logInPage() {
		System.out.println("\n							      Log-In Page\n");
		System.out.println("						1- User Name : ");
		System.out.println("						2- Password : ");
		System.out.println("\n You should enter this informations in a line with this order; 1,2... and put semicolon between them or go to previous page(p) ");
		System.out.println("\n Ex : serdar;123456");
		System.out.print("Write : ");
		
	}
	
	public void customerPage(IUser user) {
		System.out.println(String.format("						Customer Page              User id : %d\n", user.getUserId()));
		System.out.println("							1- Add a complaint");
		System.out.println("							2- See previous complaints\n");
		System.out.print("						Choose 1 or 2 , go to previous page(p) : ");
		
	}
	
	public void producerPage(IUser user) {
		System.out.println(String.format("						Producer Page              User id : %d\n", user.getUserId()));
		System.out.println("							1- Add a product");
		System.out.println("							2- See related complaints\n");
		System.out.print("						Choose 1 or 2 , go to previous page(p) : ");
		
	}
	
	public void adminPage(IUser user) {
		System.out.println(String.format("						Admin Page              User id : %d\n", user.getUserId()));
		
		
	}
	
	public void addComplintPage() {
		System.out.println("\n							      Add complaint Page\n");
		System.out.println("						1- Complaint title : ");
		System.out.println("						2- Complaint : ");
		System.out.println("\n You should enter this informations in a line with this order; 1,2... and put semicolon between them or , go to previous page(p) ");
		System.out.println("\n Ex : fun noise;coming fun noise ");
		System.out.print("Write : ");
	}
	
	public void complaintList(IComplaint complaint,IUser user,IProduct product,int index) {
		System.out.println(String.format("%d - | %d | %s | %s | %s | %s ",index,
				complaint.getComplaintId(),user.getDisplayedName(),product.getProductName(),complaint.getComplaintTitle(),
				complaint.getStatus().toString()));
	}
	public void chosenComplaint(IComplaint complaint,IUser user,IProduct product) {
		System.out.println(String.format("Complaint id : %d",complaint.getComplaintId()));
		if(user.getUserType() == UserTypes.PRODUCER) {System.out.println(String.format("Producer name : %s", user.getDisplayedName()));}
		else{System.out.println(String.format("Customer name : %s",user.getDisplayedName()));}
		System.out.println(String.format("Product name : %s",product.getProductName()));
		System.out.println(String.format("Complaint title : %s",complaint.getComplaintTitle()));
		System.out.println(String.format("Complaint : %s",complaint.getComplaint()));
		System.out.println(String.format("Complaint status : %s",complaint.getStatus().toString()));
	}
	
	public void complaintListForAdmin(IComplaint complaint,IUser customer,IUser producer,IProduct product,int index) {
		System.out.println(String.format("%d - | %d | %s | %s | %s | %s | %s",index,
				complaint.getComplaintId(),customer.getDisplayedName(),producer.getDisplayedName(),product.getProductName(),complaint.getComplaintTitle(),
				complaint.getStatus().toString()));
	}
	public void chosenComplaintForAdmin(IComplaint complaint,IUser customer,IUser producer,IProduct product) {
		System.out.println(String.format("Complaint id : %d",complaint.getComplaintId()));
		System.out.println(String.format("Producer name : %s", producer.getDisplayedName()));
		System.out.println(String.format("Customer name : %s",customer.getDisplayedName()));
		System.out.println(String.format("Product name : %s",complaint.getComplaintId()));
		System.out.println(String.format("Complaint title : %s",complaint.getComplaintTitle()));
		System.out.println(String.format("Complaint : %s",complaint.getComplaint()));
		System.out.println(String.format("Complaint status : %s",complaint.getStatus().toString()));
		System.out.print("Chanege status of complaint; Working(w), Fixed(f), New(n), Seen(s), Deleted(d)  or Previous Page(p) : ");
	}

	public void userList(ArrayList<IUser> users) {
		for(IUser user : users) {
			System.out.println(String.format("%d - | %d | %s ",users.indexOf(user)+1,user.getUserId(),user.getDisplayedName()));
		}
		System.out.println();
		System.out.print(" Choose a producer : ");
	}
	
	public void productTypeList(ArrayList<String> productTypes) {
		for(String productType : productTypes) {
			System.out.println(String.format("%d -  %s ",productTypes.indexOf(productType)+1,productType));
		}
		System.out.println();
		System.out.print(" Choose a product type  ");
	}
	
	public void productList(ArrayList<IProduct> products) {
		for(IProduct product : products) {
			System.out.println(String.format("%d -  | %d | %s",products.indexOf(product)+1,product.getProducerId(),product.getProductName()));
		}
		System.out.println();
		System.out.print(" Choose a product : ");
	}
	
	public void statusErrorMessage() {
		System.out.println("you enter wrong input or complaint is Fixed!! status didnt change, press any key to turn back");
	}
	
	public void statusChangedMessage() {
		System.out.println("Changed Successfully !!  press any key to go to previous page");
	}
	public void wrongEntry() {
		System.out.println("You enter wrong entry or format !!");
	}

}
