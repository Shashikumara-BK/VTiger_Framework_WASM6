package DataDrivenTestingPractice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromExcelContact {
	 public static void main(String[] args) throws Exception {
		 
		 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	   		Properties pobj = new Properties();
	   		pobj.load(fis);
	   		String BROWSER = pobj.getProperty("browser");
	   		String URL= pobj.getProperty("url");
	   		String USERNAME = pobj.getProperty("username");
	   		String PASSWORD = pobj.getProperty("password");
	   		
			FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\TEST_DATA.xlsx");
			Workbook wb= WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("contact");
		
			Row rw = sh.getRow(1);
			Cell col = rw.getCell(2);
			String LASTNAME = col.getStringCellValue();
			//System.out.println("LASTNAME = "+LASTNAME);
			
			Row rw1 = sh.getRow(4);
			Cell col1 = rw1.getCell(3);
			String ORGNAME = col1.getStringCellValue();
			//System.out.println("ORGNAME = "+ ORGNAME);
			
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
		    driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		    Thread.sleep(3000);
		    driver.findElement(By.name("account_name")).sendKeys(ORGNAME);
		    Thread.sleep(3000);
		    driver.findElement(By.name("button")).click();
			Actions actions = new Actions(driver);
			Thread.sleep(5000);
			actions.moveToElement(driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"))).click().perform();
			actions.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
			
}
}