import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class GoogleSearch {

    @Test
    public void test001() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com/");

        WebElement textInput = driver.findElement(By.cssSelector(".gLFyf"));
        textInput.sendKeys("Portnov");
        textInput.submit();

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement resultStatElement = driver.findElement(By.id("result-stats"));

        String resultStatsText = resultStatElement.getText();
        String[] stringArray = resultStatsText.split(" ");
        String amountOfResults = stringArray[1];
        String amountOfResultFixed = amountOfResults.replace(",", "");

        int amountOfResultsParsed = Integer.parseInt(amountOfResultFixed);

        Assert.assertTrue(amountOfResultsParsed>100);

        driver.close();



    }
}
