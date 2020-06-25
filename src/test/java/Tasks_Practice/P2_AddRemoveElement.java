package Tasks_Practice;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
XPATH PRACTICESDO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
 1. Open Chrome browser
 2. Go to http://practice.cybertekschool.com/add_remove_elements
 3. Click to “Add Element” button
 4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
 */
public class P2_AddRemoveElement {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        driver.manage().window().maximize();
        WebElement addElementButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();
        WebElement deletButton=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if(deletButton.isDisplayed()){
            System.out.println("Delete button is Displayed. PASS!");
        }else {
            System.out.println("Delete button is Displayed. Fail!");
        }

        try {
            deletButton.click();
            if (!deletButton.isDisplayed()){
                System.out.println("Delete button is NOT Displayed. PASS!");
            }else {
                System.out.println("Delete button is NOT Displayed. FAIL!");
            }
        }catch (StaleElementReferenceException exception){
            System.out.println("StaleElementException has been thrown.");
            System.out.println("It means element has been completely deleted from the HTML.");
            System.out.println("Delete button is not display. verification PASS!");

        }


    }
}
