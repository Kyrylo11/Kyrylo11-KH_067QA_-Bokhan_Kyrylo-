package Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeMethod
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeSite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.quit();
    }
}
