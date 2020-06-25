package Day02_findElements_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_SmartBear_Title {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC#5:	Basic	login	authentication1-Open	a	chrome	browser
        2-Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        3-Verify	title	equals:Expected:	Web	Orders	Login
        4-Enter	username:	Tester
        5-Enter	password:	test
        6-Click	“Sign	In”	button
        7-Verify	titleequals:Expected:	Web	Orders
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        String actual=driver.getTitle();
        String expected="Web Orders Login";
        if(expected.equals(actual)){
            System.out.println("Home page Title Passed");
        }else{
            System.out.println("Home page Title Failed");
        }
        Thread.sleep(5000);
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        Thread.sleep(5000);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        Thread.sleep(5000);
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        Thread.sleep(5000);

        String actualn="Web Orders";
        String expectedn=driver.getTitle();
        if(expectedn.equals(actualn)){
            System.out.println("Landing page title verification Passed");
        }else{
            System.out.println("Landing page title verification Failed");
        }
        driver.close();






    }
}
