package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBox.sendKeys("rozetka ua");
        searchBox.submit();
        WebElement first_link = driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]"));
        first_link.click();
        WebElement searchBoxOnLink = driver.findElement(By.xpath("//input[@name='search']"));
        searchBoxOnLink.sendKeys("airpods pro");
        WebElement search = driver.findElement(By.xpath("(//button)[6]"));
        search.click();
        WebElement first_product = driver.findElement(By.xpath("(//span[@class='goods-tile__title'])[1]"));
        first_product.click();
        WebElement buy = driver.findElement(By.xpath("(//button[@type='button'])[17]"));
        buy.click();
        driver.quit();
    }
}
