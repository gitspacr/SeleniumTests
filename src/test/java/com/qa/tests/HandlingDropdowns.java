package com.qa.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropdowns {
	
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
		
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//handling single selection dropdowns
//		WebElement slctCourse = driver.findElement(By.xpath("//select[@id='course']"));
//		System.out.println("list of course: "+slctCourse);
//		Select selectCourse = new Select(slctCourse);
//		List<WebElement> lstCourse =selectCourse.getOptions();
//		System.out.println(lstCourse.size());
//		for (WebElement getCourse : lstCourse) {
//			String txtVal = getCourse.getText();
//			System.out.println("List of course: "+txtVal);
//			
//		}
//		selectCourse.selectByIndex(2);
//		selectCourse.selectByVisibleText("Python");
//		selectCourse.selectByValue("js");
//		String value =selectCourse.getFirstSelectedOption().getText();
//		System.out.println("print the selected value from the dropdown: "+value);
		//handling multi selection dropdowns
		WebElement slctCourse = driver.findElement(By.xpath("//select[@id='ide']"));
		System.out.println("list of course: "+slctCourse);
		Select selectCourse = new Select(slctCourse);
		List<WebElement> lstCourse =selectCourse.getOptions();
		System.out.println(lstCourse.size());
		for (WebElement getCourse : lstCourse) {
			String txtVal = getCourse.getText();
			System.out.println("List of course: "+txtVal);
			
		}
		selectCourse.selectByIndex(2);
		selectCourse.selectByVisibleText("Eclipse");
//		selectCourse.selectByValue("js");
		List<WebElement> value =selectCourse.getAllSelectedOptions();
		System.out.println("size of the values "+value.size());
		for (WebElement getIDE : value) {
			String txtValIde = getIDE.getText();
			System.out.println("List of course: "+txtValIde);
			
		}
		Thread.sleep(3000);
		driver.quit();
		

	}

}
