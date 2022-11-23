package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericLibrary.WebDriverLibrary;

public class CreateOrganisationInfoPage extends WebDriverLibrary{
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrganisationHeaderText;
	
	//Initialization
	public CreateOrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilisation

	public WebElement getOrganisationHeaderText() {
		return OrganisationHeaderText;
	}
	//Business Library
	public String getOrganisationHeader()
	{
	return OrganisationHeaderText.getText();
    }
}
