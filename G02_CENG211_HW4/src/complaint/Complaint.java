package complaint;

import enums.Status;
import serviceClasses.IdGenerator;

/*This Complaint class include complaints information 
 * and extend IdGenerator to generate id automatically for complaints
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Complaint extends IdGenerator implements IComplaint{
	private int customerId;
	private int producerId;
	private int productId;
	private int complaintId;
	private String complaintTitle;
	private String complaint;
	private Status status;
	
	public Complaint() {
		this(0,0,0,"","");
	}	
	public Complaint(int customerId, int producerId, int productId, String complaintTitle, String complaint) {
		this.productId = productId;
		this.customerId = customerId;
		this.producerId = producerId;
		this.complaintId = generateID();
		this.complaintTitle = complaintTitle;
		this.complaint = complaint;
		this.status = Status.NEW; 
	}

	public Complaint(int complaintId, int customerId, int producerId, int productId, String complaintTitle, String complaint, Status status) {
		this.productId = productId;
		this.customerId = customerId;
		this.producerId = producerId;
		this.complaintId = complaintId;
		this.complaintTitle = complaintTitle;
		this.complaint = complaint;
		this.status = status; 
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getProducerId() {
		return producerId;
	}


	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getComplaintId() {
		return complaintId;
	}


	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}


	public String getComplaintTitle() {
		return complaintTitle;
	}


	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}


	public String getComplaint() {
		return complaint;
	}


	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}
	
}
