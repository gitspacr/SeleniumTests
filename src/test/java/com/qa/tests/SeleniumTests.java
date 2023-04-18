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

public class SeleniumTests {
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
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//identification the web objects or web element = find the web element of the application
		//perform action on these web element = actions
		//selenium provides locators - id, name , classname, linktext, partiallinktext,tagname,xpath, css selector
		driver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);
		String countTag =driver.findElement(By.tagName("a")).getTagName();
		Thread.sleep(3000);
		System.out.println("no of links in the application: "+countTag);
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
//		Thread.sleep(3000);
		//close browser
		driver.quit();
		
		
		

	}

}
