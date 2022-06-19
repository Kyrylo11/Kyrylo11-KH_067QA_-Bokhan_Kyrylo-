package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class First {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.google.com/";
        String query = "rozetka ua";

        By searchFieldGoogle = By.xpath("//input[@class='gLFyf gsfi']");
        By firstElementGoogle = By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])");
        By katalog = By.xpath("//button[@id='fat-menu']");
        By checkboxSeler = By.xpath("//a[@class='checkbox-filter__link']");
        By firstElementRozetka = By.xpath("//span[@class='goods-tile__title']");
        By monitors = By.xpath("//a[contains(@href,'monitors/c80089/')]");

        driver.get(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(searchFieldGoogle).sendKeys(query);
        driver.findElement(searchFieldGoogle).submit();
        driver.findElement(firstElementGoogle).click();
        driver.findElement(katalog).click();
        driver.findElement(monitors).click();
        driver.findElement(checkboxSeler).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstElementRozetka));
        driver.findElement(firstElementRozetka).click();
        driver.quit();
    }
}
