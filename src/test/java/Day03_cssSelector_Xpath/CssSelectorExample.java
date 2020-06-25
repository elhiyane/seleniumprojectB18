package Day03_cssSelector_Xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelectorExample {

    public static void main(String[] args) throws InterruptedException {
        /*
         //Search Amazon
        //1.Open browser
        //2. Go to https://amazon.com
        //3. Enter any search term (use cssSelector to locate search box)
        //4.Verify title contains the search term
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
        WebElement amazonsearch=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        amazonsearch.sendKeys("wooden spoon"+ Keys.ENTER);
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle.toString());
        String expectedTtle="wooden spoon";

        if(expectedTtle.contains(actualTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification Failed!");
        }





    }
}
