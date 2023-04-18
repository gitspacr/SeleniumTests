package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicControls {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		
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
		//handling text box
		driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@ng-model='FirstName']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys("Automation");
		String getTxt =driver.findElement(By.xpath("//input[@ng-model='FirstName']")).getAttribute("value");
		System.out.println(getTxt);
		Thread.sleep(3000);
		driver.quit();
		

	}

}
