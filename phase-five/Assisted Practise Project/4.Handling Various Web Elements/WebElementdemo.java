package com.simplilearn.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementdemo {

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	        WebDriver driver= new ChromeDriver();
	      
 
	        driver.get("https://www.naukri.com/registration/createAccount?othersrcp=23531&wExp=N&utm_source=google&utm_medium=cpc&utm_campaign=Brand_Misspellings&gclid=CjwKCAjw8sCRBhA6EiwA6_IF4QAMpEQhG0dw_-dcHhvcRIjiNe0XpG6CnbkbQTP3eJBFVPV0DW3CeRoCmgAQAvD_BwE&gclsrc=aw.ds");
 
	        WebElement name= driver.findElement(By.id("name"));
 
	        name.sendKeys("gaurav");
	        
	        WebElement email= driver.findElement(By.id("email"));
	        
	        email.sendKeys("gaurav@gmail.com");
	        
           WebElement password= driver.findElement(By.id("password"));
	        
           password.sendKeys("gaurav@12345");
 
           WebElement mobile= driver.findElement(By.id("mobile"));
	        
           mobile.sendKeys("1234567890");
           
           WebElement button= driver.findElement(By.cssSelector("#root > div > div > div.right-container > div > div > div.formWrapper > form > div.formElems > div.formField.submitWrap > button"));
	        
           button.submit();
 
	}

	
	

}
