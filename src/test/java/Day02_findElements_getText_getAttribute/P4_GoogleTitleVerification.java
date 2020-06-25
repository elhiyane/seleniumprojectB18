package Day02_findElements_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    public static void main(String[] args) throws InterruptedException {
/*
TC#4:	Google	search
1-Open	a	chrome	browser
2-Go	to:	https://google.com
3-Write“apple”	in	search	box
4-Click	google	search	button
5-Verify	title:Expected:	Title	should	start	with	“apple
 */
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://google.com");
        Thread.sleep(3000);

       driver.findElement(By.name("q")).sendKeys("apple");

        Thread.sleep(3000);
        driver.findElement(By.name("btnK")).click();
        String actualTitle=driver.getTitle();
        String expectedTitle="apple";
        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }














    }
}
