package cargoPackages;

import eCommerceSitres.Amazon;
import eCommerceSitres.HepsiBurada;
import eCommerceSitres.IECommerceSites;
import eCommerceSitres.N11;
import eCommerceSitres.Trendyol;
import exceptions.CargoCodeFormatException;
import exceptions.SiteNotSupportedException;

/*
 *This ECommerceCargoPackage class is used for every e-commerce sites and its generic for cargo code
 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuğrul Demir  260201059
 */

public  class ECommerceCargoPackage<T> extends CargoPackage<T> implements IECommerceCargoPackage<T>,ICargoPackage<T>  {
	private String siteName;
	private String status;
	
	
	public ECommerceCargoPackage() {
		this("",null,0,0,0,0,0);
	}
	public ECommerceCargoPackage(String siteName, T cargoCode, int weight, int width, int lenght, int height, int count) {
		super(cargoCode,weight,width,lenght,height);
		this.siteName = siteName;
		this.status = setStatus(cargoCode,count);
	}

	public String getSiteName() {
		return siteName;
	}

	public String getStatus() {
		return status;
	}
	
	public T getCargoCode() {
		return super.getCargoCode();
	}
	
	public int calculateSize() {
		return super.calculateSize();
	}

	
	// set the status according to code format and daily limit(count is number of cargo package)
	@SuppressWarnings("unchecked")
	public String setStatus(T cargoCode, int count) {
		String status = "Not Accepted";
		// we use checkCodeFormat method in each case according to site, 
		// if it does not throw exception check for count otherwise catch 
		// the CargoCodeFormatException and return Not accepted
		// Also you should implement new case for new e-commerce site otherwise throw SiteNotSupportedException
		try {
			switch (siteName) {
			case "Amazon":
				IECommerceSites<T> amazon = (IECommerceSites<T>) new Amazon();
				amazon.checkCodeFormat(cargoCode);
				if((count < amazon.getDailyLimit())){
					return "Accepted";
				}
				break;
			case "Hepsiburada":
				IECommerceSites<T> hepsiburada = (IECommerceSites<T>) new HepsiBurada();
				hepsiburada.checkCodeFormat(cargoCode); 
				if((count < hepsiburada.getDailyLimit())){
					return "Accepted";
				}
				break;
			case "N11":
				IECommerceSites<T> n11 = (IECommerceSites<T>) new N11();
				n11.checkCodeFormat(cargoCode);
				if((count < n11.getDailyLimit())){
					return "Accepted";
				}
				break;
			case "Trendyol":
				IECommerceSites<T> trendyol = (IECommerceSites<T>) new Trendyol();
				trendyol.checkCodeFormat(cargoCode);
				if((count < trendyol.getDailyLimit())){
					return "Accepted";
				}
				break;

			default:
				throw new SiteNotSupportedException("E-Commerce site  " + siteName + " not supported for now!");
			}
			
		} catch (CargoCodeFormatException e) {
			return status;
		}
		catch (SiteNotSupportedException e) {
			System.out.println(e.getMessage());
		}

		return status;
	}
	



	

}
