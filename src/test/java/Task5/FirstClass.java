package Task5;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

@Listeners(CustomListener.class)
public class FirstClass extends BaseTest {
    @Test(groups = {"positive"})
    public void firstTest() {
        String query = "iPhone";

        SearchResultsPage searchRes = new HomePage(driver)
                .search(query);
        searchRes.getResultProducts();
        Assert.assertNotNull(searchRes.getResultsWebElements());
    }

    @Test(groups = {"negative"}, expectedExceptions = {RuntimeException.class})
    public void secondTest() {
        String query = "Глазковыколупыватель";

        SearchResultsPage searchRes = new HomePage(driver)
                .search(query);
        searchRes.getResultProducts();
        searchRes.getResultsWebElements();
    }

    @Test(groups = {"positive"})
    public void thirdTest() {
        String query = "iPhone";

        SearchResultsPage searchRes = new HomePage(driver)
                .search(query);
        CheckBoxPage.addAkcii();
        searchRes.getResultProducts();
        Assert.assertNotNull(searchRes.getResultsWebElements());
    }

    @Test(groups = {"positive"})
    public void fourthTest() {
        String query = "iPhone";

        SearchResultsPage searchRes = new HomePage(driver)
                .search(query);
        searchRes.getResultProducts();
        searchRes.clickFirstProduct();
        ProductPage.buy();
        CartPage.getResultsWebElements();
        Assert.assertNotNull(searchRes.getResultsWebElements());
    }
}
