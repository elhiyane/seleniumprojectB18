package Day02_findElements_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_LinkTextLocator {
    /*
    TC #3: Back and forth navigation
    1-Open a chrome browser
    2-Go to: https://google.com
    3-Click to Gmail from top right.
    4-Verify title contains:Expected: Gmail
    5-Go back to Google by using the .back();
    6-Verify title equals:Expected: Google
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.linkText("Gmail")).click();
        String expected="Gmail";
        String actualResult=driver.getTitle();
        if(actualResult.contains(expected)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        driver.navigate().back();
        String expectedResult="Google";
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedResult)){
            System.out.println("Google page title verfication Passed");
        }else {
            System.out.println("Google page title verfication Failed");
        }
        driver.close();





    }
}
