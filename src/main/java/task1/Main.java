package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        search.sendKeys("rozetka ua");
        search.submit();
        WebElement first = driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])"));
        first.click();
        WebElement searchLink = driver.findElement(By.xpath("//input[@name='search']"));
        searchLink.sendKeys("airpods pro");
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='header-search js-app-search-suggest']" +
                "/form/button"));
        searchButton.click();
        WebElement firstProduct = driver.findElement(By.xpath("(//span[@class='goods-tile__title'])"));
        firstProduct.click();
        WebElement emptyClick = driver.findElement(By.xpath("//div[@class='product-about__text']/span"));
        emptyClick.click();
        WebElement buyButton = driver.findElement(By.xpath("//app-product-buy-btn/app-buy-button/button"));
        buyButton.click();
        driver.quit();
    }
}
