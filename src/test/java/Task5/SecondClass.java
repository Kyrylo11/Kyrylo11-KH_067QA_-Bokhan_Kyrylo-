package Task5;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.KatalogPage;
import pages.SearchResultsPage;
import pages.ToUsersPage;

public class SecondClass extends BaseTest {
    private By smartphones = By.xpath("//main[@role = 'main']//li[@data-category='32014']");

    @Test(groups = {"positive"})
    public void firstTest() {
        By iPhone11 = By.xpath("//main[@role = 'main']//a[contains(@href,'mobilnye_telefony_apple-iphone-11.html')]");

        SearchResultsPage searchRes = new KatalogPage(driver)
                .moveToElementInElement(smartphones, iPhone11);
        searchRes.getResultProducts();
        Assert.assertNotNull(searchRes.getResultsWebElements());
    }

    @Test(groups = {"positive"})
    public void secondTest() {
        KatalogPage searchRes = new KatalogPage(driver)
                .clickElement(smartphones);
        Assert.assertNotNull(searchRes.getKatalogResultPage());
    }

    @Test(groups = {"negative"}, expectedExceptions = {RuntimeException.class})
    public void thirdTest() {
        By iPhone15 = By.xpath("//main[@role = 'main']//a[contains(@href,'mobilnye_telefony_apple-iphone-15.html')]");

        SearchResultsPage searchRes = new KatalogPage(driver)
                .moveToElementInElement(smartphones, iPhone15);
        searchRes.getResultProducts();
    }

    @Test(groups = {"positive"})
    public void fourthTest() {
        ToUsersPage toUsersPage = new ToUsersPage(driver)
                .clickUsersButton()
                .clickInformationAboutPay();
        Assert.assertNotNull(toUsersPage.getResultsWebElements());
    }

    @Test(groups = {"positive"})
    public void fifthTest() {
        ToUsersPage toUsersPage = new ToUsersPage(driver)
                .clickUsersButton()
                .clickInformationAboutUs();
        Assert.assertNotNull(toUsersPage.getResultsWebElements());
    }
}
