package test.shopper;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToCart {

    @Test
    public void AddingCart1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Martina\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://react-shopping-cart-67954.firebaseapp.com/");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Catalog catalogPage = new Catalog(driver);
        catalogPage.findSizeL().click();

        Thread.sleep(3000);

        for (int i = 0; i < 3; i++) {
            catalogPage.tshirtToCart().click();
        }

        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);

        String subtotalZ = catalogPage.getCartSubTotal().getText();

        Assert.assertEquals(subtotalZ, "$ 27.00");

        catalogPage.clickX().click();
        catalogPage.secondToCart().click();

        String subtotalW = catalogPage.getCartSubTotal().getText();
        Assert.assertEquals(subtotalW, "$ 41.00");

        Thread.sleep(3000);

        catalogPage.deleteShirt().click();
        catalogPage.deleteShirt2().click();
    }
}
