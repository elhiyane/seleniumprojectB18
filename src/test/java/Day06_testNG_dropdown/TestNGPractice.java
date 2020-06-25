package Day06_testNG_dropdown;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {
    @BeforeClass
    public void before_class(){
        System.out.println("Before class is running=====>");
    }
    @AfterClass
    public void after_class(){
        System.out.println("After classs is running======>");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method is running...");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method is running...");
    }
    @Test
    public void test1(){
        System.out.println("Test1 is running...");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("Test2 is running...");
        Assert.assertEquals("string1","string1","String verfication on test2 failed");
    }
    @Test
    public void test3(){
        System.out.println("Test3 is running...");
        String actualTitle="Amazon prime";
        String expectedTitle=" prime";
        String testString="gvdjvcacj";
        //if the boolean value  we pass in assertTrue is "true", assertion will pass.
        //else it will fail
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //Assert.assertFalse(actualTitle.contains(testString));


    }
}
