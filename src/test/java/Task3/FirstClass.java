package Task3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class FirstClass extends BaseTest {
    @Test(groups = {"positive"})
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        By searchField = By.xpath("//input[@type='search']");
        By productsTable = By.xpath("//div[@class='listing__body-wrap image-switch']");
        String query = "iPhone";
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTable));
        List<WebElement> elementList = driver.findElements(productsTable);
        Assert.assertTrue(elementList.contains(query));
    }

    @Test(groups = {"negative"})
    public void secondTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        By searchField = By.xpath("//input[@type='search']");
        By productsTable = By.xpath("//div[@class='listing__body-wrap image-switch']");
        String query = "Глазковыколупыватель";
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).submit();
        Assert.assertTrue(driver.findElement(productsTable).isDisplayed());
    }

    @Test(groups = {"positive"})
    public void thirdTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        By searchField = By.xpath("//input[@type='search']");
        By productsTable = By.xpath("//div[@class='listing__body-wrap image-switch']");
        By checkboxStock = By.xpath("//label[@for='sidebar-check-input-aktsii']");
        By buttonShow = By.xpath("//a[@class='listing__submit-apply']");
        String query = "iPhone";
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).submit();
        driver.findElement(checkboxStock).click();
        driver.findElement(buttonShow).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTable));
        List<WebElement> elementList = driver.findElements(productsTable);
        Assert.assertTrue(elementList.contains(query));
    }

    @Test(groups = {"positive"})
    public void fourthTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        By searchField = By.xpath("//input[@type='search']");
        By firstProduct = By.xpath("//a[@class='card__title']");
        By buttonBuy = By.xpath("//div[@class='button product-box__main-buy__button buy-button product-buy-button']");
        By basket = By.xpath("//div[@class='header-tooltip__cards smooth-scroll']");
        String query = "iPhone";
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        driver.findElement(firstProduct).click();
        driver.findElement(buttonBuy).click();
        List<WebElement> elementList = driver.findElements(basket);
        Assert.assertTrue(elementList.contains(query));
    }
}
