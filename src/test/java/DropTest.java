import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class DropTest {
    @Test
    public void dropTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));

        List<WebElement> selects = select.getOptions();

        select.selectByIndex(1);
        WebElement select1 = select.getFirstSelectedOption();
        softAssert.assertEquals(select1.getText(), "Option 1");

        select.selectByIndex(2);
        WebElement select2 = select.getFirstSelectedOption();
        softAssert.assertEquals(select1.getText(), "Option 2");

        driver.quit();
    }
}
