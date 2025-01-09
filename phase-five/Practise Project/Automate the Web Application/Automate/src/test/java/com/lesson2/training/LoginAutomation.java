package com.lesson2.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginAutomation {
@Test
public void login() {
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.browserstack.com/users/sign_in");
driver.findElement(By.cssSelector("#user_email_login")).sendKeys("abc@gmail.com");
driver.findElement(By.id("user_password")).sendKeys("your_password");
WebElement login=driver.findElement(By.cssSelector("#user_submit"));
login.click();
//String actualUrl="https://live.browserstack.com/dashboard";
//String expectedUrl= driver.getCurrentUrl();
//Assert.assertEquals(expectedUrl,actualUrl);
}
}
