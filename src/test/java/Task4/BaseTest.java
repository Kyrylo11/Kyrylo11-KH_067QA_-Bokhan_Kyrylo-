package Task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void openSite() {
        driver = new ChromeDriver();
        driver.get("https://www.apple.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeSite() {
        driver.quit();
    }
}
