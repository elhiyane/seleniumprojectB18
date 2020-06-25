package Day02_findElements_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_EtsyTitleVerfication {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC #1: EtsyTitle Verification
        1.Open Chrome browser
        2.Go to https://www.etsy.com
        3.Search for “wooden spoon”
        4.Verify title: Expected: “Wooden spoon | Etsy”
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://etsy.com");
        Thread.sleep(3000);
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon");
        Thread.sleep(3000);
        driver.findElement(By.className("wt-input-btn-group__btn")).click();
        Thread.sleep(3000);
        String expectedTitle="Wooden spoon | Etsy";
        String actualTitle= driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {

            System.out.println("Etsy title verification Passed");
        }else {
            System.out.println("Etsy title verification Failed");
        }
        driver.close();
    }
}
