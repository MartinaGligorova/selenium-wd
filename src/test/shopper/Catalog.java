package test.shopper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Catalog {

    WebDriver driver;

    public Catalog(WebDriver driver) {
        this.driver = driver;
    }

    By sizes = By.xpath("//span[text()='L']");
    By tshirt1Add = By.xpath("//div[@data-sku='10686354557628304']");
    By clickX = By.xpath("//div[text()='X']");
    By secondTshirtAdd = By.xpath("//*[@id='root']/main/div[2]/div[3]");
    By deleteShirt = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]");
    By deleteShirt2 = By.xpath("/html/body/div/div/div[2]/div[2]/div/div[1]");
    By subtotal = By.xpath("//p[@class='sub-price__val']");


    public WebElement findSizeL() {
        return driver.findElement(sizes);
    }

    public WebElement tshirtToCart() {
        return driver.findElement(tshirt1Add);
    }

    public WebElement clickX() {
        return driver.findElement(clickX);
    }

    public WebElement secondToCart() {
        return driver.findElement(secondTshirtAdd);
    }

    public WebElement deleteShirt() {
        return driver.findElement(deleteShirt);
    }

    public WebElement deleteShirt2() {
        return driver.findElement(deleteShirt2);
    }

    public WebElement getCartSubTotal() {
        return driver.findElement(subtotal);
    }
}