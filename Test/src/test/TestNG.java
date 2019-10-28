package test;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG {

	WebDriver    driver;

	/**
	 * 
	 * Initilazing the browser
	 * */ 

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "G:\\Drivers\\chromedriver.exe");
		driver    =    new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

	}

	
	@Test
	@Parameters({"UID" , "PWD"})
	public void TC_Login(String UID,String PWD) {
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(UID);
		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys(PWD);
		driver.findElement(By.id("SubmitLogin")).click();
		// how to pick the URL in selenium
		String   actualURL     =       driver.getCurrentUrl();
		String   expectedURL   =     "http://automationpractice.com/index.php?controller=my-accountt";

		if(actualURL.equals(expectedURL))	{

			System.out.println("Test Case PASS");
		}	
		else {
			System.out.println("Test Case FAIL");
		}

		driver.findElement(By.xpath("//a[@title='Log me out']")).click();

	}




	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}



}
