package DataDrivenTestingPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertyFileContact {
	public static void main(String[] args) throws IOException, Exception  {
		
		//load the file into the java stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//create the obj for properties class
		Properties pobj = new Properties();
		
		//load the file input stream to properties
		pobj.load(fis);
		
		//use the key to read the values
		String BROWSER = pobj.getProperty("browser");
		//System.out.println(BROWSER);
		
		String URL= pobj.getProperty("url");
		//System.out.println(URL);
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		WebDriver driver = null;
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver();
			 driver = new FirefoxDriver(); 
		}
		else 
		{
			System.out.println("invalid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(USERNAME);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
	    driver.findElement(By.name("lastname")).sendKeys("shashi");
	    driver.findElement(By.name("button")).click();
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		actions.moveToElement(driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"))).click().perform();
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
}
}