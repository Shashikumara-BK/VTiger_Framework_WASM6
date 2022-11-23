package vTigerOrganisationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationRandomlyTest {
     @Test
     public void createOrganisationRandomlyTest() throws IOException, InterruptedException{
    	   
    	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
   		Properties pobj = new Properties();
   		pobj.load(fis);
   		String BROWSER = pobj.getProperty("browser");
   		String URL= pobj.getProperty("url");
   		String USERNAME = pobj.getProperty("username");
   		String PASSWORD = pobj.getProperty("password");
   		
    	   FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\TEST_DATA.xlsx");
		   Workbook wb= WorkbookFactory.create(fis1);
			
			Sheet sh = wb.getSheet("organisation");
			Row rw=sh.getRow(7);
			Cell col = rw.getCell(2);
			String ORGNISATIONNAME=col.getStringCellValue();
			
		/*	Cell col1 = rw.getCell(3);
			String INDUSTRY=col1.getStringCellValue();
			
			Cell col2 = rw.getCell(4);
			String TYPE=col2.getStringCellValue(); */
			
			Random ran=new Random();
			int Value= ran.nextInt(500);
			String RanName = ORGNISATIONNAME+Value;
			
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[text()='Organizations']")).click();
			driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.name("accountname")).sendKeys(RanName);
			
			Thread.sleep(5000);
			
			WebElement ele=driver.findElement(By.name("industry"));
			Select sel = new Select(ele);
			sel.selectByVisibleText("Healthcare");
			
			/*Thread.sleep(5000);
			WebElement ele1= driver.findElement(By.name("accounttype"));
			Select sel1= new Select(ele1);
			sel1.selectByVisibleText(TYPE); */
			
			driver.findElement(By.name("button")).click();
			
			Actions actions = new Actions(driver);
			Thread.sleep(5000);
			actions.moveToElement(driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"))).click().perform();
			actions.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
			
	}
}
