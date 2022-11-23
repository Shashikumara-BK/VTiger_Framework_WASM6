package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericLibrary.WebDriverLibrary;

public class CreateNewOrganisationPage extends WebDriverLibrary{
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryNameDropDown;
	
	@FindBy(name="accounttype")
	private WebElement TypeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialization
	public CreateNewOrganisationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
     
	//Utilisation
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryNameEdt() {
		return IndustryNameDropDown;
	}

	public WebElement getTypeDropDown() {
		return TypeDropDown;
	}

	public void setTypeDropDown(WebElement typeDropDown) {
		TypeDropDown = typeDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	public void CreateNewOrganisation(String OrganisationName)
	{
		OrgNameEdt.sendKeys(OrganisationName);
		SaveBtn.click();
	}
	public void CreateNewOrganisation(String OrganisationName, String IndustryName)
	{
		OrgNameEdt.sendKeys(OrganisationName, IndustryName );
		SaveBtn.click();
	}
	public void CreateNewOrganisation(String OrganisationName ,String IndustryName, String Type)
	{
		OrgNameEdt.sendKeys(OrganisationName);
	    handleDropDown(IndustryName, IndustryNameDropDown);
	    handleDropDown(Type, TypeDropDown);
		SaveBtn.click();
	}
	
}
