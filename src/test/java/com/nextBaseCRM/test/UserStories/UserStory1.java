package com.nextBaseCRM.test.UserStories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class UserStory1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://login2.nextbasecrm.com/");

        ArrayList<String> validUserNames = new ArrayList<String>(Arrays.asList("helpdesk25@cybertekschool.com",
                "helpdesk26@cybertekschool.com", "marketing25@cybertekschool.com",
                "marketing26@cybertekschool.com", "hr25@cybertekschool.com",
                "hr26@cybertekschool.com"));

        String passWord = "UserUser";

        for (String eachUser : validUserNames){
            driver.findElement(By.name("USER_LOGIN")).sendKeys(eachUser);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(passWord);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='USER_REMEMBER']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='Log In']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[@class='user-name']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[.='Log out']")).click();
            Thread.sleep(3000);
            driver.findElement(By.name("USER_LOGIN")).clear();

        }

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class='login-link-forgot-pass']")).click();

        String expectedTitle = "Get Password";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("You access the Get Password page. PASSED");
        }else{
            System.err.println("FAILED!");
        }



        Thread.sleep(3000);
        driver.close();
    }
}
/*
User Story:
1. As a user, I should be able to login to the app
Acceptance Criteria:
1. Verify users can login
2. verify users can check ""Remember me on this computer"" option
3. Verify users can access to ""FORGOT YOUR PASSWORD?"" link page
 */