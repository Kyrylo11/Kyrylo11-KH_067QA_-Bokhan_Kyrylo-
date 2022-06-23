package Task4;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstClass extends BaseTest {
    @DataProvider(name = "queriesForSearch")
    public Object[] queries() {
        return new Object[]{"iPhone 11", "airpods pro", "MacBook"};
    }

    @Test(groups = {"positive"}, dataProvider = "queriesForSearch")
    public void firstTest(String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By buttonSearch = By.xpath("//a[@id='ac-gn-link-search']");
        By searchField = By.xpath("//input[@id='ac-gn-searchform-input']");
        By productsTable = By.xpath("//section[@class='rf-accessoriesgrid column']");
        By buttonAccessories = By.xpath("//li[@class='tabnav-item rf-serp-search-tabnav-item']" +
                "/button[@data-autom='accessories']");
        driver.findElement(buttonSearch).click();
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        driver.findElement(buttonAccessories).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTable));
        List<WebElement> elementList = driver.findElements(productsTable);
        Assert.assertNotNull(elementList);
    }

    @Test(groups = {"positive"})
    public void secondTest() {
        By buttonStore = By.xpath("//a[@class='ac-gn-link ac-gn-link-store']");
        By airpods = By.xpath("//div[@class='rf-productnav-card-image']/img[contains(@srcset,'airpods')]");
        By airpods3rd = By.xpath("//div[@class='airpods-3rd-gen device third-gen-new-update']");
        By buttonBuy = By.xpath("//a[@class='ac-ln-button']");
        By buttonAdd = By.xpath("//button[@id='add-to-cart']");
        By bag = By.xpath("//ol[@class='rs-bag-items rs-iteminfos']");
        driver.findElement(buttonStore).click();
        driver.findElement(airpods).click();
        driver.findElement(airpods3rd).click();
        driver.findElement(buttonBuy).click();
        driver.findElement(buttonAdd).click();
        List<WebElement> elementList = driver.findElements(bag);
        Assert.assertNotNull(elementList);
    }

    @Test(groups = {"negative"}, expectedExceptions = {RuntimeException.class})
    public void thirdTest() {
        By bag = By.xpath("//li[@class='ac-gn-item ac-gn-bag']");
        By bagTableEmpty = By.xpath("//ul[@class='ac-gn-bagview-bag ac-gn-bagview-bag-one']");
        driver.findElement(bag).click();
        driver.findElement(bagTableEmpty);
    }

    @Test(groups = {"positive"})
    public void fourthTest() {
        By buttoniPhone = By.xpath("//li[@class='ac-gn-item ac-gn-item-menu ac-gn-iphone']");
        By buttonCompare = By.xpath("//li[@class='chapternav-item chapternav-item-compare']");
        By models = By.xpath("//div[@role='cell']");
        driver.findElement(buttoniPhone).click();
        driver.findElement(buttonCompare).click();
        List<WebElement> elementList = driver.findElements(models);
        int k = elementList.size();
        Assert.assertEquals(3, k);
    }

    @Parameters({"query"})
    @Test(groups = {"positive"})
    public void fifthTest(@Optional("iphone 13") String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By buttonSearch = By.xpath("//a[@id='ac-gn-link-search']");
        By searchField = By.xpath("//input[@id='ac-gn-searchform-input']");
        By productsTable = By.xpath("//section[@class='rf-accessoriesgrid column']");
        By buttonAccessories = By.xpath("//li[@class='tabnav-item rf-serp-search-tabnav-item']" +
                "/button[@data-autom='accessories']");
        driver.findElement(buttonSearch).click();
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        driver.findElement(buttonAccessories).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTable));
        List<WebElement> elementList = driver.findElements(productsTable);
        Assert.assertNotNull(elementList);
    }
}
