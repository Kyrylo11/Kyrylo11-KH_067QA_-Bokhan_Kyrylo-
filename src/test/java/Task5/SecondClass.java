package Task5;

import Task3.BaseTest;
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
        By smartphones = By.xpath("//main[@role = 'main']//li[@data-category='32014']");
        By productsTable = By.xpath("//div[@class='listing__body-wrap image-switch']");
        By iPhone11 = By.xpath("//main[@role = 'main']//a[contains(@href,'mobilnye_telefony_apple-iphone-11.html')]");
        WebElement element = driver.findElement(smartphones);
        WebElement iphone = driver.findElement(iPhone11);
        actionProvider.moveToElement(element).moveToElement(iphone).click().build().perform();
        List<WebElement> elementList = driver.findElements(productsTable);
        Assert.assertNotNull(elementList);
    }

    @Test(groups = {"positive"})
    public void secondTest() {
        By smartphones = By.xpath("//main[@role = 'main']//li[@data-category='32014']");
        By categoryTable = By.xpath("//div[@class='category']");
        driver.findElement(smartphones).click();
        List<WebElement> elementList = driver.findElements(categoryTable);
        Assert.assertNotNull(elementList);
    }
}
