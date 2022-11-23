package PomPractice;

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
import vTiger.ObjectRepository.CreateNewOrganisationPage;
import vTiger.ObjectRepository.CreateOrganisationInfoPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganisationPage;
import vTigerGenericLibrary.BaseClass;
import vTigerGenericLibrary.ExcelFileLibrary;
import vTigerGenericLibrary.JavaLibrary;
import vTigerGenericLibrary.PropertyFileLibrary;
import vTigerGenericLibrary.WebDriverLibrary;

@Listeners (vTigerGenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactWithOrgPOMTest extends BaseClass{
	@Test(groups 	="smokeSuite")
	public void createContactWithOrgPOMTest() throws IOException {
		
			String ORGNAME = eLib.readDataFromExcel("organisation", 7, 2)+jLib.getRandomNumber();
			String INDNAME = eLib.readDataFromExcel("organisation", 7, 3);
			String TYPENAME = eLib.readDataFromExcel("organisation", 7, 4);
			String LASTNAME = eLib.readDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();
				
				HomePage hp = new HomePage(driver);
				hp.clickOrgnisationLnk();
				
				OrganisationPage op=new OrganisationPage(driver);
				op.clickOnCreateOrgImg();
				
				CreateNewOrganisationPage cop = new CreateNewOrganisationPage(driver);
				cop.CreateNewOrganisation(ORGNAME, INDNAME, TYPENAME);
				
				CreateOrganisationInfoPage of = new CreateOrganisationInfoPage(driver);
				String OrganizationHeader = of.getOrganisationHeader();
						
				Assert.assertTrue(OrganizationHeader.contains(ORGNAME), "organisation created");
				
		        hp.clickContactLnk();
				
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactImg();
				
				CreateNewContactPage ccp= new CreateNewContactPage(driver);
				ccp.createNewContactWithOrganization(LASTNAME, driver, ORGNAME);
				
				ContactsInfoPage cip = new ContactsInfoPage(driver);
				String headText = cip.getContactHeader();
				Assert.assertTrue(headText.contains(LASTNAME),"contact created");
	}
	
}
