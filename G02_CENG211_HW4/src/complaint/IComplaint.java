package complaint;

import enums.Status;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public interface IComplaint {

	int getCustomerId();
	void setCustomerId(int customerId);
	public int getProducerId();
	void setProducerId(int producerId);
	int getProductId();
	void setProductId(int productId);
	int getComplaintId();
	void setComplaintId(int complaintId);
	String getComplaintTitle();
	void setComplaintTitle(String complaintTitle);
	String getComplaint();
	void setComplaint(String complaint);
	public Status getStatus();
	public void setStatus(Status status);
}
