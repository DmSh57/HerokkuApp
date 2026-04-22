import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckBoxTest {
    @Test
    public void checkBoxes() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        boolean isCheck1 = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        softAssert.assertFalse(isCheck1);

        driver.findElements(By.cssSelector("[type=checkbox]")).get(0).click();

        boolean isCheck11 = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertTrue(isCheck11);

        boolean isCheck2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertTrue(isCheck2);

        driver.findElements(By.cssSelector("[type=checkbox]")).get(1).click();

        boolean isCheck22 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertFalse(isCheck22);

        driver.quit();
    }
}
