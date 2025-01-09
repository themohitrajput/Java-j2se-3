package com.simplilearn.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
	public static void main(String[] args) {
		  //set the driver property
        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://m.facebook.com/");
        
        WebElement email= driver.findElement(By.xpath("//*[@id=\"m_login_email\"]"));
        email.sendKeys("gaurav@gmail.com");
        
        WebElement pass= driver.findElement(By.xpath("//*[@id=\"m_login_password\"]"));
        pass.sendKeys("gaurav@11.com");
        
       WebElement button= driver.findElement(By.xpath("//*[@id=\"login_password_step_element\"]/button"));
        button.submit();
     WebElement email1= driver.findElement(By.cssSelector("input[id*='mail']"));
      System.out.println(email1.getAttribute("placeholder"));
       
       WebElement button1= driver.findElement(By.cssSelector("button[value='Log In'][type='button']"));
      button1.submit();
       System.out.println(button1.getAttribute("data-sigil"));
        //driver.close();
	}

}
