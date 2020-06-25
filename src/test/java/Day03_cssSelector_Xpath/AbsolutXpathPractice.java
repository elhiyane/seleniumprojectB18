package Day03_cssSelector_Xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbsolutXpathPractice {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement homeLink= driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
        if(homeLink.isDisplayed()){
            System.out.println("home link is displayed on the page. Pass!");
        }else {
            System.out.println("home link is displayed on the page. Fail!");
        }

    }
}
