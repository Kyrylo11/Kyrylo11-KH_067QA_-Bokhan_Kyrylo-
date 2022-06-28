package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends BasePage {
    private By results = new By.ByXPath("//div[@class='listing__body-wrap image-switch']");
    private By firstProduct = new By.ByXPath("//div[@class='listing__body-wrap image-switch']//div");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage getResultProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(results));
        return new ProductPage(driver);
    }

    public List<WebElement> getResultsWebElements() {
        List<WebElement> resultsWebElements = driver.findElements(results);
        return resultsWebElements;
    }

    public ProductPage clickFirstProduct() {
        driver.findElement(firstProduct).click();
        return new ProductPage(driver);
    }
}
