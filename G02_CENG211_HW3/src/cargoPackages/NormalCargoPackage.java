package cargoPackages;

import exceptions.IDNotCorrectException;
/*
 * this NormalCargoPackage is used for normal cargo types, extends CargoPAckage
 * We initialize the Integer for cargo code
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public class NormalCargoPackage extends CargoPackage<Integer> implements INormalCargoPackage,ICargoPackage<Integer>{
	
	private long senderId;
	private String senderName;
	private String recipientName;
	private String recipientAddress;
	private String status;
	
	
	public NormalCargoPackage() {
		this(0,"","","",0,0,0,0);		
	}
	
	public NormalCargoPackage(long senderId,String senderName, String recipientName, String recipientAddress, int weight, int width, int lenght, int height) {
		super(Code.generateCargoCode(7),weight, width, lenght, height);
		this.senderId = senderId;
		this.senderName = senderName;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
		this.status = setStatus(senderId);
		
	}
	
	

	public long getSenderId() {
		return senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}
	

	
	public double calculatePrice() {
		int size = super.calculateSize();
		return  (18.5)+3*size;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	// we return status as string to use it assign in beginning 
	@Override
	public String setStatus(Long senderId) {
		status = "Not Accepted";
		
		try {
			if(senderId.toString().length() == 11 && isNumeric(senderId)) {
				status = "Accepted";
				return status;
			}
			else {
				throw new IDNotCorrectException("Sender Id " + this.senderId + " not correct");
			}
		}
		catch (IDNotCorrectException e) {
			//System.out.println(e.getMessage());       //we do not want to see the exception on the screen, 
			return status;								//if you want you can disable comment block
		}

	}
	
	
	
	// We created inner class to use a method in super 
	// constructor otherwise we cannot use a method which is defined in outer class
	static class Code {
		// generate max 9-digit random number
		private static int generateCargoCode(double lenght) {
			double min = Math.pow(10, lenght);
			double max = min*10 - 1;
			return (int)(Math.random() * (max - min + 1) + min);
		}
	}






	
	

}
