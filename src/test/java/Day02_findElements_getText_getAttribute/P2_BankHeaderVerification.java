package Day02_findElements_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_BankHeaderVerification {
    /*
   TC #2: Zero Bankheader verification
   1.Open Chrome browser
   2.Go to http://zero.webappsecurity.com/login.html
   3.Verify header textExpected: “Log in to ZeroBank”
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        String actualHeader=driver.findElement(By.tagName("h3")).getText();
        String expectedHeader="Log in to ZeroBank";
        if(actualHeader.equals(expectedHeader)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

    }
}
