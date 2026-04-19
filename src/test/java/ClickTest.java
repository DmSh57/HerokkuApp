import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ClickTest {
    @Test
    public void clickTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.linkText("Click here")).click();

        String actualText = driver.findElement(By.className("flash")).getText();
        softAssert.assertTrue(actualText.contains("Action successful") || actualText.contains("Action unsuccesful"));

        WebElement flash = driver.findElement(By.className("flash"));
        String icon = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", flash).toString();
        softAssert.assertNotNull(icon);
        softAssert.assertAll();
        driver.quit();
    }
}

