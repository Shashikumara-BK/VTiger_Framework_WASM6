package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary{
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement orgnisationlnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlnk;
	
	@FindBy (linkText ="Products")
	private WebElement productlnk;
	
	@FindBy (linkText ="Opportunities")
	private WebElement opportunitieslnk;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administratorimg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signoutlnk;
	
	//initialisation
	public HomePage(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilisation

	public WebElement getOrgnisationlnk() {
		return orgnisationlnk;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}

	public WebElement getProductlnk() {
		return productlnk;
	}

	public WebElement getOpportunitieslnk() {
		return opportunitieslnk;
	}

	public WebElement getAdministratorimg() {
		return Administratorimg;
	}

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	// business library
	/**
	 * This method will click on organizations link
	 */
	public void clickOrgnisationLnk()
	{
		orgnisationlnk.click();
	}
	/**
	 * This method will click on contacts link
	 */
	public void clickContactLnk()
	{
		contactlnk.click();
	}
	public void clickproductLnk()
	{
		productlnk.click();
	}
	/**
	 * This method will perform sign out of the application
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, Administratorimg);
		signoutlnk.click();
	}
}
