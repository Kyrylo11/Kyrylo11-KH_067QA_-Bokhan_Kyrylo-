package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    private static By basket = By.xpath("//div[@class='header-tooltip__cards smooth-scroll']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static List<WebElement> getResultsWebElements() {
        List<WebElement> resultsWebElements = driver.findElements(basket);
        return resultsWebElements;
    }
}