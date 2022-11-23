package PomPractice;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTigerGenericLibrary.BaseClass;
import vTigerGenericLibrary.ExcelFileLibrary;
import vTigerGenericLibrary.JavaLibrary;
import vTigerGenericLibrary.PropertyFileLibrary;
import vTigerGenericLibrary.WebDriverLibrary;

@Listeners (vTigerGenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactTest extends BaseClass {
	@Test (groups ="smokeSuite")
	public void createContactTest() throws IOException{
		
		String LASTNAME = eLib.readDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();
		
		//step 5:navigate to contacts link
		HomePage hp=new HomePage(driver);
		hp.clickContactLnk();
		
		//step 6:navigate create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		//step 7:create contact with mandatory fields and save
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME);
		
		//step 8:validate
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		System.out.println(contactHeader);
		
		Assert.assertTrue(contactHeader.contains(LASTNAME),"contact created");
	}
	@Test  (groups ="regressionSuite")
	public void createContactDemo()
	{
		System.out.println("contact demo created successfully");
		Assert.fail();
	}
	@Test 
	public void createLeadSource()
	{
		System.out.println("leadsource created successfully");
		Assert.fail();
	}
}
