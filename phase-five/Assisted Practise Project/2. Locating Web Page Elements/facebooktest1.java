package com.simplilearn.demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebooktest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("pass"));
        
        email.sendKeys("sonam@gmail.com");
        pass.sendKeys("Sonam@123");
        
        WebElement login= driver.findElement(By.name("login"));
        login.submit();
	}

}
