package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathTests {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		
		
		//Step1: launch the browser
		String browser = "chrome";
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Selenium provides locators - id, name , classname, linktext, partiallinktext,tagname,xpath, css selector
		//formula xpath:  //tagname[@attribute='value'], '//' means anywhere in the html dom structure
		//2 types xpath: 1.Relative xpath : //tagname[@attribute='value']
		//2.Absolute xpath: /html/div/
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("selenium");
//		WebElement eleTxt = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
//		eleTxt.sendKeys("selenium");
		driver.findElement(By.xpath("//input[@ng-model='LastName']")).sendKeys("tests");
		driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys("tests@gmail.com");
		driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("5146758787");
		driver.findElement(By.xpath("//input[@type='radio' and @value='FeMale']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='Cricket']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='Button1']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
		

	}

}
