package Day03_cssSelector_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class P3_CybertekURLVerification {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC #3: PracticeCybertek/ForgotPassword URL verification
        1.Open Chrome browser
        2.Go to http://practice.cybertekschool.com/forgot_password
        3.Enter any email into input box
        4.Click on Retrieve password
        5.Verify URL contains: Expected: “email_sent”
        6.Verify textbox displayed the content as expected.
        Expected: “Your e-mail’s been sent!”
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInput=driver.findElement(By.name("email"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        emailInput.sendKeys("msnghk@gmail.com");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement retrievePassword=driver.findElement(By.id("form_submit"));
        retrievePassword.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);



        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="email_sent";
        System.out.println("The current URL: "+actualUrl);
        if(actualUrl.contains(expectedUrl)){
            System.out.println("URL verification Passed!");

        }else {
            System.out.println("URL verfication Failed");
        }

        //6.Verify textbox displayed the content as expected.
        //        Expected: “Your e-mail’s been sent!”
        WebElement textDisplay=driver.findElement(By.name("confirmation_message"));
        String actualText=textDisplay.getText();
        String expectedText="Your e-mail's been sent!";
        System.out.println(actualText);
        if(actualText.equals(expectedText)){
            System.out.println("Confirmation message text verification Passed!");
        }else{
            System.out.println("Confirmation message text verification Failed!");
        }
         if(textDisplay.isDisplayed()){
             System.out.println("Message text verification PASSED!");
         }else {
             System.out.println("Message text verification FAILED!");
         }





    }
}
