import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Anotations {

    @Test
    public void testCase1() {
        System.out.println("in test case 1");
    }

    @Test
    public void tesatCase2() {
        System.out.println("in test case 2");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Message before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test message");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method message");
    }
}
