package com.nextBaseCRM.test.UserStories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStory2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://login2.nextbasecrm.com/");
        Thread.sleep(3000);

        String userName = "helpdesk25@cybertekschool.com";
        String passWord = "UserUser";

        driver.findElement(By.name("USER_LOGIN")).sendKeys(userName);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(passWord);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='USER_REMEMBER']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']")).click();
        Thread.sleep(3000);

        WebElement send = driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']"));
        if (send.isDisplayed()){
            System.out.println("You can send a message. PASSED");
        }else{
            System.err.println("You can NOT send any messages. FAILED!");
        }

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-link']")).click();

        Thread.sleep(3000);
        if (send.isDisplayed()){
            System.out.println("You can send a message. PASSED");
        }else{
            System.err.println("You can NOT send any messages. FAILED!");
        }

        Thread.sleep(3000);
        driver.close();


    }
}
/*
User Story:
2. As a user, I should be able to send message.
Acceptance Criteria:
"1. Verify users can send message by clicking ""MESSAGE"" tab
2. Verify users can cancel message.
3. Veriy users can attach link by clicking on the link icon."
 */