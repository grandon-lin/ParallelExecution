package com.parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTest {
	
	WebDriver driver;
	
	@Test(groups="Chrome")
	public void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		try 
		{
			Thread.sleep(2000);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(groups="Chrome", dependsOnMethods="launchChrome")
	public void tryFacebook1()
	{
		System.out.println(Thread.currentThread().getId());
		
		driver.findElement(By.id("email")).sendKeys("ravi10thstudent@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12345");
		driver.findElement(By.name("login")).click();
	}
	
	@Test(groups="Firefox")
	public void launchFirefox()
	{
		System.setProperty("webdriver.gecko.driver", "./Resource/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		try
		{
			Thread.sleep(4000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(groups="Firefox", dependsOnMethods="launchFirefox")
	public void tryFacebook2()
	{
		System.out.println(Thread.currentThread().getId());
		
		driver.findElement(By.id("email")).sendKeys("ravi10thstudent@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("ravi28394");
		driver.findElement(By.name("login")).click();
		System.out.println(Thread.currentThread().getId());
	}
}
