package Day04_FindElement_checkbox_Radio;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P04_Cybertek_Checkboxes {
    public static void main(String[] args) {
        /*
        Practice:	Cybertek	Checkboxes1.Go	to	http://practice.cybertekschool.com/checkboxes
        2.Confirm	checkbox	#1	is	NOT	selected	by	default
        3.Confirm	checkbox	#2	is	SELECTED	by	default.
        4.Click	checkbox	#1	to	select	it.
        5.Click	checkbox	#2	to	deselect	it.
        6.Confirm	checkbox	#1	is	SELECTED.
        7.Confirm	checkbox	#2	is	NOT
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement checkbox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

        if(!checkbox1.isSelected()){
            System.out.println("Checkbox 1 is not selected.Verfication PASSED");
        }else {
            System.out.println("Checkbox 1 is selected.Verfication FAILED");
        }
        WebElement checkbox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if(checkbox2.isSelected()){
            System.out.println("Checkbox 2 is selected by default.Verfication PASSED");
        }else {
            System.out.println("Checkbox 2 is not selected by default.Verfication FAILED");
        }



    }
}
