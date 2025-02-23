import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static java.lang.Thread.sleep;

public class WindowHandlesTest {

    private static final String WINDOWS_MAIN_PAGE = "https://the-internet.herokuapp.com/windows";

    WebDriver driver;
    private String originalWindowHandle;
    private String newWindowHandle;

    @BeforeSuite
    public void testSuiteSetup(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
    
    //1. Open the browser
    //2. Goto window page
    //3. Click on click Here link
    //4. Verify the amount of windows is 2
    //5. Verify new window text
    //6. Switch back to original window
    //7. Verify the original window title
    @Test
    public void test001() {
        String expectedNewWindowTitle = "New Window";
        String expectedNewWindowText = "New Window";

        openWindowsPage();
        clickOnLink();
        verifyAmountOfWindows(2);
        switchToNewWindow();
        verifyWindowTitle(expectedNewWindowTitle);
        verifyWindowText(expectedNewWindowText);
        switchToOriginalWindow();
        verifyWindowTitle("The Internet");
    }

    // TODO: create dif scenario

    private void switchToNewWindow() {
        driver.switchTo().window(newWindowHandle);
    }

    private void switchToOriginalWindow() {
        driver.switchTo().window(originalWindowHandle);
    }

    private void verifyWindowText(String expectedText) {
        Assert.assertTrue(driver.getPageSource().contains(expectedText));
    }

    private void verifyWindowTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    private void verifyAmountOfWindows(int expectedAmounts) {
        //TODO change this to explicit wait
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> windowHandles = driver.getWindowHandles();
        int actualAmountOfHandles = windowHandles.size();
        Assert.assertEquals(actualAmountOfHandles, expectedAmounts);

        originalWindowHandle = (String) windowHandles.toArray()[0];
        newWindowHandle = (String) windowHandles.toArray()[1];
    }

    private void clickOnLink() {
        // change this to class attribute
        By expectedElements = By.linkText("Click Here");
        WebElement webElement = waitForElement(expectedElements);
        webElement.click();
    }

    private WebElement waitForElement(By expectedElements) {
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        WebElement foundedElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(expectedElements));
        return(foundedElement);
    }

    private void openWindowsPage() {
        driver.get(WINDOWS_MAIN_PAGE);
    }
}
