package test.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    By loginForm = By.xpath("//div[@class='login-form ng-scope']");
    By usernameField = By.xpath("//input[@id='username']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@class='btn btn-light-blue']");
    By message = By.xpath("//div[@class='message ng-binding']");
    By mandatoryUserFieldMsg = By.xpath("//span[@class='ng-scope']");
    By mandatoryPassFieldMsg = By.xpath("//div[@id='password']//span[@class='ng-scope']");
    By resetPasswordLink = By.xpath("//a[contains(text(),'Reset Password')]");
    By resetForm = By.xpath("//div[@class='row reset']");
    By emailField = By.xpath("//input[@id='email']");
    By sendButton = By.xpath("//button[@class='btn btn-primary']");
    By resetMsgField = By.xpath("//div[@class='alert alert-success']");
    By dropdownButton = By.xpath("//button[@class='btn btn-default dropdown-toggle']");

    public WebElement dropdownElement() {

        return driver.findElement(dropdownButton);
    }

    public boolean dropdownButtonText() {

        return dropdownElement().getText().contains("pr1@sharklasers.com");
    }

    public WebElement sendButtonToReset() {

        return driver.findElement(sendButton);
    }

    public WebElement emailElement() {

        return driver.findElement(emailField);
    }

    public WebElement resetPasswordForm() {

        return driver.findElement(resetForm);
    }

    public WebElement resetLink() {

        return driver.findElement(resetPasswordLink);
    }

    public WebElement logInForm() {

        return driver.findElement(loginForm);
    }

    public WebElement usernameElement() {

        return driver.findElement(usernameField);
    }

    public WebElement passwordElement() {

        return driver.findElement(passwordField);
    }

    public WebElement loginButton() {

        return driver.findElement(loginButton);
    }

    public WebElement alertMsg() {

        return driver.findElement(message);
    }

    public boolean alertBoxText() {

        return alertMsg().getText().contains("Wrong username or password.");
    }

    public WebElement mandatoryUserField() {

        return driver.findElement(mandatoryUserFieldMsg);
    }

    public boolean mandatoryUserFieldMsg() {

        return mandatoryUserField().getText().contains("This field is mandatory.");
    }

    public WebElement mandatoryPassField() {

        return driver.findElement(mandatoryPassFieldMsg);
    }

    public boolean mandatoryPassFieldMsg() {

        return mandatoryPassField().getText().contains("This field is mandatory.");
    }

    public WebElement resetFieldElement() {

        return driver.findElement(resetMsgField);
    }

    public boolean resetFieldMessage() {

        return resetFieldElement().getText().contains("Password reset initiated.");
    }
}
