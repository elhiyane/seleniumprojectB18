package day07_javafaker_webtables;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectTask3 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
    @Test
    public void task3_select_date_test(){
        // 3.Select “December 1st, 1921” and verify it is selected.
        // Select year using: visible textSelect
        Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1921");

        String yearActual=yearDropdown.getFirstSelectedOption().getText();
        String yearExpected="1921";

        // month using value attributeSelect
        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");
        String monthActual=monthDropdown.getFirstSelectedOption().getText();
        String monthExpected="December";

        // day using: index number
        Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);
        String dayActual=dayDropdown.getFirstSelectedOption().getText();
        String dayExpected="1";
        //Asserting year dropdown value vs expected
        Assert.assertEquals(yearActual,yearExpected);
        //Asserting month dropdown value vs expected
        Assert.assertEquals(monthActual,monthExpected);
        //Asserting day dropdown value vs expected
        Assert.assertEquals(dayActual,dayExpected);




    }


}
