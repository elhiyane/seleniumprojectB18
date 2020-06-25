package day07_javafaker_webtables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {
    @Test
    public void faker_test(){
        Faker faker=new Faker();
        String name=faker.name().fullName();
        System.out.println("name = " + name);
        String firstname=faker.name().firstName();
        System.out.println("firstname = " + firstname);
        String lastname=faker.name().lastName();
        System.out.println("lastname = " + lastname);
        
        String streetAddress=faker.address().streetAddress();
        System.out.println("streetAddress = " + streetAddress);
    }

    
}
