package serviceClasses;

import java.util.ArrayList;
import complaint.IComplaint;
import product.IProduct;
import users.IUser;

/* This interface is used for initialize the values from file
 * 
 * @author  Serdar Sertg�z  260201030
 * @author  Ertu�rul Demir  260201059
 */

public interface IInitialization {
	ArrayList<IProduct> getProductArrayList();
	ArrayList<IUser> getUserArrayList();
	ArrayList<IComplaint> getComplaintArrayList();

}
