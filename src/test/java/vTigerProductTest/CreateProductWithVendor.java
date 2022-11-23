package vTigerProductTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerGenericLibrary.ExcelFileLibrary;
import vTigerGenericLibrary.JavaLibrary;
import vTigerGenericLibrary.PropertyFileLibrary;
import vTigerGenericLibrary.WebDriverLibrary;

public class CreateProductWithVendor {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		JavaLibrary jLib= new JavaLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();
		
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String PRODNAME = eLib.readDataFromExcel("product", 1, 2)+jLib.getRandomNumber();
		String VENDORNAME = eLib.readDataFromExcel("product", 1, 3)+jLib.getRandomNumber();
		
	    WebDriver driver = null;
	    
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager. chromedriver().setup();
	    	driver =new ChromeDriver();
	    }
	    else if (BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    }
	    else {
	    	System.out.println("invalid driver name");
	    }
	    
	    wLib.maximiseWindow(driver);
	    wLib.waitForPageLoad(driver);
	    driver.get(URL);
	    
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement DROPDOWNLIST = driver.findElement(By.id("qccombo"));
		wLib.handleDropDown(DROPDOWNLIST, "Vendors");
		driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys(PRODNAME);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		wLib.switchToWindow(driver, "Vendors");
		driver.findElement(By.id("search_txt")).sendKeys(VENDORNAME);
		driver.findElement(By.name("search")).click();
		wLib.switchToWindow(driver, "Products");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String productHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println(productHeader);
		
		if(productHeader.contains(PRODNAME))
		{
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHoverOn(driver, adminImg);
		driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
