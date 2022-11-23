package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericLibrary.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary {
	//declaration
		@FindBy(name="lastname")
		private WebElement lastNameEdt;
		
		@FindBy(name="leadsource")
		private WebElement leadSourceDropDown;
		
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
		private WebElement organizationImg;
		
		@FindBy(name="search_text")
		private WebElement searchEdt;
		
		@FindBy(name="search")
		private WebElement searchBtn;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//initialization
		public CreateNewContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}

		public WebElement getLeadSourceDropDown() {
			return leadSourceDropDown;
		}

		public WebElement getOrganizationImg() {
			return organizationImg;
		}

		public WebElement getSearchEdt() {
			return searchEdt;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		// Business Library
		public void createNewContact(String lastname) 
		{
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
		}
		public void createNewContact(String lastname,String leadsourceValue)
		{
			lastNameEdt.sendKeys(lastname);
			handleDropDown(leadSourceDropDown, leadsourceValue);
			saveBtn.click();
		}
		 public void createNewContactWithOrganization(String lastname,WebDriver driver, String ORGNAME) {
				lastNameEdt.sendKeys(lastname);
				organizationImg.click();
				switchToWindow(driver, "Accounts");
				searchEdt.sendKeys(ORGNAME);
				searchBtn.click();
				driver.findElement(By.linkText(ORGNAME));
				switchToWindow(driver, "Contacts");
				saveBtn.click();
				
			}
}    
