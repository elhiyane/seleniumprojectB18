package Tasks_Practice;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Dropdown_DefaultValue {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");git
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void month_default_values_test(){
        Select monthDropdown=new Select(driver.findElement(By.id("month")));
        String actualMonth=monthDropdown.getFirstSelectedOption().getText();

        DateTimeFormatter monthFormator=DateTimeFormatter.ofPattern("MMMM");
        LocalDate localMonth=LocalDate.now();
        String expectedMonth=localMonth.format(monthFormator);

        Assert.assertEquals(actualMonth,expectedMonth);




    }



}
