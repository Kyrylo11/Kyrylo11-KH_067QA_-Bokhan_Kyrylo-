package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckBoxPage extends BasePage {
    private static By checkboxStock = By.xpath("//label[@for='sidebar-check-input-aktsii']");
    private static By buttonShow = By.xpath("//a[@class='listing__submit-apply']");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public static SearchResultsPage addAkcii() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxStock));
        driver.findElement(checkboxStock).click();
        driver.findElement(buttonShow).click();
        return new SearchResultsPage(driver);
    }
}
