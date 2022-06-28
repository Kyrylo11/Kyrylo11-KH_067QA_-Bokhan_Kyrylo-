package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class KatalogPage extends BasePage {
    private By categoryTable = By.xpath("//div[@class='category']");

    public KatalogPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage moveToElementInElement(By first, By second) {
        Actions actionProvider = new Actions(driver);
        WebElement element = driver.findElement(first);
        WebElement iphone = driver.findElement(second);
        actionProvider.moveToElement(element).moveToElement(iphone).click().build().perform();
        return new SearchResultsPage(driver);
    }

    public KatalogPage clickElement(By element) {
        driver.findElement(element).click();
        return new KatalogPage(driver);
    }

    public List<WebElement> getKatalogResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryTable));
        List<WebElement> resultsWebElements = driver.findElements(categoryTable);
        return resultsWebElements;
    }
}
