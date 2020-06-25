package Day03_cssSelector_Xpath;

import Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class ExampleForWebDriverFactory {
    public static void main(String[] args) {
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://google.com");
    }
}
