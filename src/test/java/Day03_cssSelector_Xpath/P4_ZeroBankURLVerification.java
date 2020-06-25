package Day03_cssSelector_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #4: Zero Bank URLverification
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Get attribute value of href from the “forgot your password”link
4.Verify attribute value containsExpected: “/forgot-password.html”
 */
public class P4_ZeroBankURLVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement forgetElement=driver.findElement(By.partialLinkText("Forgot"));
        String forgotPasswordLink=forgetElement.getAttribute("href");
        System.out.println("Actual Href value:" +forgotPasswordLink);
        String actualResult=forgotPasswordLink;
        String expectedResult="/forgot-password.html";
        if(actualResult.contains(expectedResult)){
            System.out.println("the attribute value is PASSED!");
        }else {
            System.out.println("the attribute value is FAILED!");
        }




    }
}
