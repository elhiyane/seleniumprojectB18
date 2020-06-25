package Day04_FindElement_checkbox_Radio;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
TC #0: FINDELEMENTS
1.Open Chrome browser
2.Go to https://www.merriam-webster.com/
3.Print out the texts of all links
4.Print out how many link is missing text
5.Print out how many link has text
6.Print out how many total link
 */
public class P01_MerriamWebster_FindElement {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.merriam-webster.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        List<WebElement> listOfLinks= driver.findElements(By.xpath("//body//a"));
        //alt+enter for windows
        int linksWithoutText=0;
        int linkWithText1=0;

        for(WebElement eachlink:listOfLinks){
           // System.out.println(eachlink.getText());
            String textOfEachLink=eachlink.getText();
            if(textOfEachLink.isEmpty()){
                linksWithoutText++;
            }else {
                System.out.println(eachlink.getText());
                linkWithText1++;
            }
        }

        System.out.println("The number of links that does not have text "+linksWithoutText);
        System.out.println("The number of links that does have text "+linkWithText1);
        System.out.println("The total number of links"+(linksWithoutText+linkWithText1));







    }
}
