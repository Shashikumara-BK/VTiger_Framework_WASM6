package vTigerPractice;

import org.testng.annotations.Test;

public class ReadDataFromCMDTest {
	@Test
	public void readDta()
	{
		String BROWSER = System.getProperty("browser");
		String USERNAME= System.getProperty("username");
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		
	}

}
