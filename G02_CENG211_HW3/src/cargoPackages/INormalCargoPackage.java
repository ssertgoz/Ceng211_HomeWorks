package cargoPackages;

import exceptions.IDNotCorrectException;


/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public interface INormalCargoPackage extends ICargoPackage<Integer>{
	
	public long getSenderId();
	public String getSenderName();
	public String getRecipientName();
	public String getRecipientAddress();
	String getStatus() ;
	String setStatus(Long senderId) throws IDNotCorrectException;
	
	double calculatePrice();

}
