package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtilities {
    public static void login(WebDriver driver){
        // 3.Enter username: “Tester”
        WebElement inputUserName=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUserName.sendKeys("Tester");

        // 4.Enter password: “test”
        WebElement inputPasword=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        inputPasword.sendKeys("test");

        // 5.Click to Login button
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
    }




}
