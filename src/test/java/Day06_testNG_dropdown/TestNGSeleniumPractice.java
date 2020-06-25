package Day06_testNG_dropdown;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGSeleniumPractice {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
        @Test(priority = 1)
        public void google_title_test(){
        //1- go to "https:google.com
        //2- Verify title :Google
        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        //the line where we do assertion
        //if you use assertTrue,
        //argument you are passing is supposed to be returning boolean
        Assert.assertTrue(actualTitle.equals(expectedTitle));
        // if you use assertEquals,
        //you need to pass two arguments of the same type
        Assert.assertEquals(actualTitle,expectedTitle);

        }
        @Test(priority = 2)
        public void google_search_title_verification(){
            //1- open browser
            //2-go to https://google.com
            //3-search "apple"
            WebElement appleSearchBox=driver.findElement(By.name("q"));
            //sending "apple" string into searchbox and pressing enter
            appleSearchBox.sendKeys("apple"+ Keys.ENTER);
            //4- verify title contains "apple"
            String actualTitle=driver.getTitle();
            String expectedTitle="apple";
            Assert.assertTrue(actualTitle.contains(expectedTitle));
            //5- close browser





    }


}
