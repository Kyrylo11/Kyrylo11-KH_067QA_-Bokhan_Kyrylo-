package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Second {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.google.com/";
        String query = "rozetka ua";
        String brand = "ASUS";

        By searchFieldGoogle = By.xpath("//input[@class='gLFyf gsfi']");
        By firstElementGoogle = By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])");
        By katalog = By.xpath("//button[@id='fat-menu']");
        By firstElementRozetka = By.xpath("//span[@class='goods-tile__title']");
        By cards = By.xpath("//a[contains(@href,'videocards/c80087/')]");
        By productionAsus = By.xpath("//a[@data-id='ASUS']");
        By searchProduction = By.xpath("//input[@name='searchline']");

        driver.get(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(searchFieldGoogle).sendKeys(query);
        driver.findElement(searchFieldGoogle).submit();
        driver.findElement(firstElementGoogle).click();
        driver.findElement(katalog).click();
        driver.findElement(cards).click();
        driver.findElement(searchProduction).sendKeys(brand);
        driver.findElement(productionAsus).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstElementRozetka));
        driver.findElement(firstElementRozetka).click();
        driver.quit();
    }
}
