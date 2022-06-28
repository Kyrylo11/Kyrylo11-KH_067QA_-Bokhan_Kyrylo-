package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ToUsersPage extends BasePage{
    private By toUsersButton = new By.ByXPath("//div[@class='header__sub-buyers unselectable']");
    private By informationAboutPayButton = new By.ByXPath("//a[@data-url='L3J1L2FydGljbGUvMTM4NQ==']");
    private By results = new By.ByXPath("//div[@class='content-page__body fox-content']");
    private By informationAboutUs = new By.ByXPath("//a[@data-url='L3J1L2FydGljbGUvNjcz']");

    public ToUsersPage(WebDriver driver) {
        super(driver);
    }

    public ToUsersPage clickUsersButton() {
        driver.findElement(toUsersButton).click();
        return new ToUsersPage(driver);
    }

    public ToUsersPage clickInformationAboutPay() {
        driver.findElement(informationAboutPayButton).click();
        return new ToUsersPage(driver);
    }

    public ToUsersPage clickInformationAboutUs() {
        driver.findElement(informationAboutUs).click();
        return new ToUsersPage(driver);
    }

    public List<WebElement> getResultsWebElements() {
        List<WebElement> resultsWebElements = driver.findElements(results);
        return resultsWebElements;
    }
}
