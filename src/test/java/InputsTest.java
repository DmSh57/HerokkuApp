import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class InputsTest {
    @Test
    public void checkInput() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/inputs");

        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        softAssert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "1");

        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        softAssert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "0");

        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("Dmitry");
        softAssert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"),"");

        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("123321");
        softAssert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"),"123321");


        driver.quit();
        softAssert.assertAll();
    }
}

