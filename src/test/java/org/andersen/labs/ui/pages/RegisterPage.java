package org.andersen.labs.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "register-submit")
    private WebElement registerButton;

    @FindBy(css = ".danger.message")
    private WebElement messageDanger;

    @FindBy(css = ".content.has-text-centered > h2")
    private WebElement welcomeMessage;

    @FindBy(css = ".username-dropdown-trigger > .username")
    private WebElement userDropDown;

    @FindBy(xpath = "//span[text()='Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[@title='Open the search/quick action bar']")
    private WebElement searchButton;

    public String registerAccount(String testcase, String username, String email, String password) {
        String actualText = "";
        userNameField.sendKeys(username);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        registerButton.click();
        if (testcase.equals("valid-username-use-case")) {
            wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
            wait.until(ExpectedConditions.visibilityOf(searchButton));
            actualText = welcomeMessage.getText();
            userDropDown.click();
            logoutButton.click();
        } else {
            actualText = messageDanger.getText();
        }
        return actualText;
    }

}
