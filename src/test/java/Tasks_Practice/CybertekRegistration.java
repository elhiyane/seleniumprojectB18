package Tasks_Practice;

import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CybertekRegistration {
    //TC#6: Cybertek registration form confirmationNote: Use JavaFaker when possible.
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/registration_form
    // 3.Enter first name
    // 4.Enter last name
    // 5.Enter username
    // 6.Enter email address
    // 7.Enter password
    // 8.Enter phone number
    // 9.Select a gender from radio buttons
    // 10.Enter date of birth
    // 11.Select Department/Office
    // 12.Select Job Title
    // 13.Select programming language from checkboxes
    // 14.Click to sign up button
    // 15.Verify success message “You’ve successfully completed registration.”is displayed.
    WebDriver driver;
    Faker faker;
    @BeforeMethod
    public void setUp(){
       driver= WebDriverFactory.getDriver("chrome") ;
       driver.get("http://practice.cybertekschool.com/registration_form");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       faker=new Faker();

    }
    @Test
    public void registrationConfirmation() throws Exception{
        // 3.Enter first name
        WebElement firstNameInput=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameInput.sendKeys(faker.name().firstName());
        Thread.sleep(2000);
        // 4.Enter last name
        WebElement lastNameInput=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameInput.sendKeys(faker.name().lastName());
        Thread.sleep(2000);

        // 5.Enter username
        WebElement userNameInput=driver.findElement(By.xpath("//input[@name='username']"));
        userNameInput.sendKeys(faker.name().username().replace(".",""));
        Thread.sleep(2000);

        // 6.Enter email address
        WebElement emailInput=driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);

        // 7.Enter password
        WebElement passwordInput=driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(faker.internet().password());
        Thread.sleep(2000);

        // 8.Enter phone number
        WebElement phoneNumber=driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("571-444-9550");
        Thread.sleep(2000);

        // 9.Select a gender from radio buttons
        WebElement genderButton=driver.findElement(By.xpath("//input[@value='male']"));
        genderButton.click();
        Thread.sleep(2000);

        // 10.Enter date of birth
        WebElement dateOfBirdInput=driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirdInput.sendKeys("03/10/1993");
        Thread.sleep(2000);

        // 11.Select Department/Office
        Select departmentDropdown=new Select(driver.findElement(By.xpath("//select[@class='form-control selectpicker']")));
        departmentDropdown.selectByValue("DE");
        Thread.sleep(2000);

        // 12.Select Job Title
        Select jobTitleDropdown=new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByVisibleText("SDET");
        Thread.sleep(2000);

        // 13.Select programming language from checkboxes
        WebElement programmingLanguageCheckboxe=driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        programmingLanguageCheckboxe.click();
        Thread.sleep(2000);

        // 14.Click to sign up button
        WebElement signUpButton=driver.findElement(By.xpath("//button[.='Sign up']"));
        signUpButton.click();
        // 15.Verify success message “You’ve successfully completed registration.”is displayed.
        WebElement successMessage=driver.findElement(By.xpath("//h4[@class='alert-heading']/following-sibling::p"));
        System.out.println(successMessage.getText());
        Assert.assertTrue(successMessage.isDisplayed());


















    }



}
