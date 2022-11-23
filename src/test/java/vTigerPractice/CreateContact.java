package vTigerPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
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
