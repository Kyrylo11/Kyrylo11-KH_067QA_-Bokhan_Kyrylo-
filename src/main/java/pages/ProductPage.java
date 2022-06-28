package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {
    private static By buyButton = new By.ByXPath(
            "//div[@class='button product-box__main-buy__button buy-button product-buy-button']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static CartPage buy() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buyButton));
        driver.findElement(buyButton).click();
        return new CartPage(driver);
    }
}