import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class GoogleSearchTest {

    @Test
    public void test001() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();

        String querrySearch = "QA school";

        driver.get("https://www.google.com");
        WebElement textInput = driver.findElement(By.cssSelector(".gLFyf"));
        textInput.sendKeys(querrySearch);
        textInput.submit();

        try {
            sleep (5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement resultStatsElement = driver.findElement(By.id("result-stats"));
        String resultStatText = resultStatsElement.getText();

        String[] stringArray = resultStatText.split(" ");
        String amountOfResults = stringArray[1].replace(",", "");

        int amountOfResultsParsed = Integer.parseInt(amountOfResults);

        Assert.assertTrue(amountOfResultsParsed > 100);


        driver.quit();
    }
}
