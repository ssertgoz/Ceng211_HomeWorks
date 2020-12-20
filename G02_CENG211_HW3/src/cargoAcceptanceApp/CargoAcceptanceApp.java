package cargoAcceptanceApp;


/*
 *This CargoAcceptanceApp class has main method and it call CargoAcceptanceAppView class to build view
 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */
public class CargoAcceptanceApp {
	
	// we use for reading file
	public static final String FILE_NAME = "HW3_PackagesToAccept";
	

	public static void main(String[] args) {
		
		CargoAcceptanceAppView view = new CargoAcceptanceAppView();
		view.viewBuilder(); // it run the program
	}

}
