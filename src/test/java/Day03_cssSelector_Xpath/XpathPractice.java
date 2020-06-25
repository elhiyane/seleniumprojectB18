package Day03_cssSelector_Xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        //a. “Home” link
        WebElement HomeLink=driver.findElement(By.xpath("//a[@class='nav-link']"));
        //b. “Forgot password” header
        WebElement forgetPassword=driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        //c. “E-mail” text
        WebElement emailText=driver.findElement(By.xpath("//label[.='E-mail']"));
        //d. E-mail input box
        WebElement emailInputBox=driver.findElement(By.xpath("//input[@type='text']"));
        //e. “Retrieve password” button
        WebElement retrievePassword=driver.findElement(By.xpath("//i[contains(@class,'icon-2x icon-signin')]"));
        //f. “Powered byCybertek School” text
        WebElement poweredByCybertek=driver.findElement(By.xpath("//a[.='Cybertek School']/..]"));

        ArrayList<WebElement> list =new ArrayList<WebElement>();
        list.addAll(Arrays.asList(poweredByCybertek,retrievePassword,emailInputBox,emailText,forgetPassword,HomeLink));
        for(WebElement each:list){
            if(each.isDisplayed()){
                System.out.println(" Pass!");
            }else {
                System.out.println(" Fail!");
            }
        }










    }
}
