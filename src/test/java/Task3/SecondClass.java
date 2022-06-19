package Task3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class SecondClass extends BaseTest {
    @Test(groups = {"positive"})
    public void firstTest() {
        Actions actionProvider = new Actions(driver);
        String query = "iPhone 11";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        By smartphones = By.xpath("//li[@data-url='L3J1L3BvcnRhbC1zbWFydGZvbmktaS10ZWxlZm9uaS5odG1s']");
        By productsTable = By.xpath("//div[@class='listing__body-wrap image-switch']");
        By iPhone11 = By.xpath("//a[@href='/ru/shop/mobilnye_telefony_apple-iphone-11.html']");
        WebElement element = driver.findElement(smartphones);
        actionProvider.moveToElement(element);
        driver.findElement(iPhone11).click();
        List<WebElement> elementList = driver.findElements(productsTable);
        Assert.assertTrue(elementList.contains(query));
    }

    @Test(groups = {"positive"})
    public void secondTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        By smartphones = By.xpath("//li[@data-url='L3J1L3BvcnRhbC1zbWFydGZvbmktaS10ZWxlZm9uaS5odG1s']");
        By categoryTable = By.xpath("//div[@class='category']");
        driver.findElement(smartphones).click();
        List<WebElement> elementList = driver.findElements(categoryTable);
        Assert.assertNotNull(elementList);
    }
}
