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
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBox.sendKeys("rozetka ua");
        searchBox.submit();
        WebElement first_link = driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]"));
        first_link.click();
        WebElement searchBoxOnLink = driver.findElement(By.xpath("//input[@name='search']"));
        searchBoxOnLink.sendKeys("airpods pro");
        WebElement search = driver.findElement(By.xpath("//button [@class='button button_color_green button_size_" +
                "medium search-form__submit ng-star-inserted']"));
        search.click();
        WebElement first_product = driver.findElement(By.xpath("(//span[@class='goods-tile__title'])[1]"));
        first_product.click();
        WebElement buy = driver.findElement(By.xpath("//button[@class='buy-button button button--with-icon" +
                " button--green button--medium ng-star-inserted']"));
        buy.click();
        driver.quit();
    }
}
