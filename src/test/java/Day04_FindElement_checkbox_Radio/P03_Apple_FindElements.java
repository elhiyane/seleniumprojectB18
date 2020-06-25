package Day04_FindElement_checkbox_Radio;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_Apple_FindElements {
    public static void main(String[] args) {
        /*
        TC #02: FINDELEMENTS_APPLE
        1.Open Chrome browser
        2.Go to https://www.apple.com
        3.Click to iPhone4.Print out the texts of all links
        5.Print out how many link is missing text
        6.Print out how many link has text
        7.Print out how many total link
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement iphoneLink=driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iphoneLink.click();
        List<WebElement> allLinks=driver.findElements(By.xpath("//body//a"));
        int linkWithoutText=0;
        int linkWithText=0;
        for(WebElement eachLink:allLinks){
            String textOfLinks=eachLink.getText();
            // Print out how many link is missing text
            if(textOfLinks.isEmpty()){
                linkWithoutText++;

            }else {
                linkWithText++;
                System.out.println(textOfLinks);
            }
        }

        System.out.println("Number Links without text ====> " +linkWithoutText);
        System.out.println("Number Links with text ====> " +linkWithText);
        System.out.println("Number of total links is: "+allLinks.size());






    }
}
