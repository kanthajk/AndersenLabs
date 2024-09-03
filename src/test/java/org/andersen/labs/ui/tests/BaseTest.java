package org.andersen.labs.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.time.Duration;
import java.util.Random;

public class BaseTest implements Constants {

    WebDriver driver;

    @BeforeTest
    public WebDriver getChromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public static String generateRandomUsername(int length) {
        Random random = new Random();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < length; i++) {
            username.append(characters.charAt(random.nextInt(characters.length())));
        }

        return username.toString();
    }

    /**
     * Parameters to register
     *
     * @param testcase
     * @param username
     * @param email
     * @param password
     * @param expectedMessage
     */
    @DataProvider(name = "loginTestData")
    public Object[][] loginTestData() {
        String validUserName = generateRandomUsername(5);
        String invalidUsername = generateRandomUsername(2);
        return new Object[][]{
                {"valid-username-use-case", validUserName, validUserName + "@vikunja.com", "p@ssword", validUserName},
                {"invalid-username-use-case", invalidUsername, invalidUsername + "@vikunja.com", "p@ssword", "Invalid Data"}
        };
    }
}
