package test.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestLogin {

    @Parameters({"webdriver", "driverPath", "URL"})
    @Test
    public void WrongDataLogin(String webdriver, String driverPath, String URL) throws InterruptedException {
        System.setProperty(webdriver, driverPath);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(URL);
        LoginPage paymentlogin = new LoginPage(driver);
        WebElement loginPart = paymentlogin.logInForm();
        js.executeScript("arguments[0].scrollIntoView();", loginPart);
        paymentlogin.usernameElement().click();
        paymentlogin.usernameElement().sendKeys("Wrong");
        paymentlogin.passwordElement().sendKeys("Wrong");
        paymentlogin.loginButton().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(paymentlogin.alertBoxText());


        //Missing Username
        Actions a = new Actions(driver);
        WebElement move = paymentlogin.usernameElement();
        a.moveToElement(move).doubleClick().build().perform();
        Thread.sleep(2000);
        a.moveToElement(move).sendKeys(Keys.BACK_SPACE).build().perform();
        paymentlogin.loginButton().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(paymentlogin.mandatoryUserFieldMsg());

        //Missing Password
        paymentlogin.usernameElement().sendKeys("Hello");
        WebElement moveToPass = paymentlogin.passwordElement();
        a.moveToElement(moveToPass).doubleClick().build().perform();
        a.moveToElement(moveToPass).sendKeys(Keys.BACK_SPACE).build().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        paymentlogin.loginButton().click();
        Assert.assertTrue(paymentlogin.mandatoryPassFieldMsg());

        //Missing Data
        a.moveToElement(move).doubleClick().build().perform();
        a.moveToElement(move).sendKeys(Keys.BACK_SPACE).build().perform();
        paymentlogin.loginButton().click();
        Assert.assertEquals(paymentlogin.mandatoryUserFieldMsg(), paymentlogin.mandatoryPassFieldMsg());

        driver.quit();
    }

    /* @Test
     public void limitedLoginAttempt(){}
     */
    @Parameters({"webdriver", "driverPath", "URL", "username"})
    @Test
    public void resetPassword(String webdriver, String driverPath, String URL, String username) throws InterruptedException {
        System.setProperty(webdriver, driverPath);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(URL);
        LoginPage paymentlogin = new LoginPage(driver);
        WebElement loginPart = paymentlogin.logInForm();
        js.executeScript("arguments[0].scrollIntoView();", loginPart);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        paymentlogin.resetLink().click();
        WebElement resetPart = paymentlogin.resetPasswordForm();
        js.executeScript("arguments[0].scrollIntoView();", resetPart);
        paymentlogin.usernameElement().click();
        paymentlogin.usernameElement().sendKeys(username);
        //enter valid username
        Thread.sleep(2000);
        paymentlogin.emailElement().click();
        //enter valid email
        paymentlogin.emailElement().sendKeys(username);
        paymentlogin.sendButtonToReset().click();
        Assert.assertTrue(paymentlogin.resetFieldMessage());
        driver.quit();
    }

    @Parameters({"webdriver", "driverPath", "URL", "username", "password"})
    @Test
    public void successfulLogin(String webdriver, String driverPath, String URL, String username, String password) {
        System.setProperty(webdriver, driverPath);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(URL);
        LoginPage paymentlogin = new LoginPage(driver);
        WebElement loginPart = paymentlogin.logInForm();
        js.executeScript("arguments[0].scrollIntoView();", loginPart);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        paymentlogin.usernameElement().click();
        paymentlogin.usernameElement().sendKeys(username);
        paymentlogin.passwordElement().click();
        paymentlogin.passwordElement().sendKeys(password);
        paymentlogin.loginButton().click();
        Assert.assertTrue(paymentlogin.dropdownButtonText());
        driver.close();
    }
}