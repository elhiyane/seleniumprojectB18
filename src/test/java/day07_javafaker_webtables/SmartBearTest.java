package day07_javafaker_webtables;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }
/*
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

 */
    @Test
    public void p1_Smartbear_software_link_verification() {
        // 6.Print out count of all the links on landing page
        List<WebElement> allLinks=driver.findElements(By.xpath("//body//a"));
        //System.out.println("Number of links: "+allLinks.size());
        int expectedNumberOfLinks=6;
        int actualNumberOfLinks=allLinks.size();
        Assert.assertEquals(actualNumberOfLinks,expectedNumberOfLinks);

        // 7.Print out each link text on this page
        for(WebElement eachLink:allLinks){
            System.out.println(eachLink.getText());
        }
    }
    @Test
    public void p2_smartbear_order_placing(){
        //TC#2: Smartbearsoftware order placing
        // 6.Click on Order
        WebElement orderLink=driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();
        // 7.Select familyAlbum from product, set quantity to 2
        Select productDropdown=new Select( driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        productDropdown.selectByVisibleText("FamilyAlbum");
        WebElement quantityInput=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        //is deleting or doing same usage of the backspace
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys("2");

        // 8.Click to “Calculate” button
        WebElement calculateButton=driver.findElement(By.xpath("//input[@type='submit']"));
        calculateButton.click();
        // 9.Fill address Info with JavaFaker•Generate: name, street, city, state, zip code
        WebElement nameInput=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        WebElement streetInput=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        WebElement cityInput=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        WebElement stateInput=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        WebElement zipCodeInput=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        Faker faker=new Faker();
        nameInput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().city());
        stateInput.sendKeys(faker.address().state());
        String zipcode=faker.address().zipCode().replaceAll("-","");
        zipCodeInput.sendKeys(zipcode);
        // 10.Click on “visa” radio button
        WebElement radioButton=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        radioButton.click();
        // 11.Generate card number using JavaFaker
        WebElement cardNumberInput=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumberInput.sendKeys(faker.finance().creditCard().replaceAll("-",""));
        //Entering date
        WebElement experationDate=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        experationDate.sendKeys("03/10");

        // 12.Click on “Process”
        WebElement processButton=driver.findElement(By.xpath("//a[.='Process']"));
        processButton.click();
        // 13.Verify success message “New order has been successfully added.”
        WebElement successMessage=driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String actualMessage=successMessage.getText();
        String expectedMessage="New order has been successfully added.";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void orderVerification(){
        WebElement verifyOrderDate=driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
       String actualDate=verifyOrderDate.getText();
       String expectedDate="01/05/2010";
       Assert.assertEquals(actualDate,expectedDate);



    }
}

