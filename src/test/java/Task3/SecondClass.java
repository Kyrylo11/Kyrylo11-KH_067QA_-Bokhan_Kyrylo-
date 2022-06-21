package Task3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SecondClass extends BaseTest {
    @Test(groups = {"positive"})
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actionProvider = new Actions(driver);
        //временно
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().window().maximize();
        By smartphones = By.xpath("//a[@href='/ru/portal-smartfoni-i-telefoni.html']");
        By productsTable = By.xpath("//div[@class='listing__body-wrap image-switch']");
        By iPhone11 = By.xpath("//a[@href='/ru/shop/mobilnye_telefony_apple-iphone-11.html']");
        WebElement element = driver.findElement(smartphones);
        actionProvider.moveToElement(element);
        driver.findElement(iPhone11).click();
        List<WebElement> elementList = driver.findElements(productsTable);
        Assert.assertNotNull(elementList);
    }

    @Test(groups = {"positive"})
    public void secondTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //временно
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().window().maximize();
        By smartphones = By.xpath("//a[@href='/ru/portal-smartfoni-i-telefoni.html");
        By categoryTable = By.xpath("//div[@class='category']");
        driver.findElement(smartphones).click();
        List<WebElement> elementList = driver.findElements(categoryTable);
        Assert.assertNotNull(elementList);
    }
}
