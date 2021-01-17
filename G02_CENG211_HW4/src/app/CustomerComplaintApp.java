package app;

import serviceClasses.ServiceClass;

/*This is the main class which runs the program and include file names
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class CustomerComplaintApp {
	public static final String COMPLAINT_FILE_NAME = "Complaint.csv";
	public static final String USER_FILE_NAME = "User.csv";
	public static final String PRODUCT_FILE_NAME = "Product.csv";
	
	public static void main(String[] args) {
		
		ServiceClass serviceClass = new ServiceClass(); // service class to run the program
		serviceClass.run();
		
	}

}
