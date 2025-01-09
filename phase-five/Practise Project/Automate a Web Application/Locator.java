package com.simplilearn.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Locator {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(1000);
	incorrectPasswordFlow(driver);
	}
	
	public static void loginFlow(WebDriver driver) {
		driver.get("https://www.phptravels.net/login");
		driver.findElement(By.name("email")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	public static void incorrectPasswordFlow(WebDriver driver) throws InterruptedException {
		String expectedErrorMessage = "Wrong credentials. try again!";
		driver.get("https://www.phptravels.net/login");
		driver.findElement(By.name("email")).sendKeys("user@phptravels.com");
		//enter incorrect password
		driver.findElement(By.name("password")).sendKeys("demo");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(500);
		String wrongCredentialsText = driver.findElement(By.className("alert-danger")).getText();
		System.out.println(wrongCredentialsText);
		Assert.assertEquals(wrongCredentialsText, expectedErrorMessage);
	}
}

