package org.andersen.labs.ui.tests;

import org.andersen.labs.ui.pages.RegisterPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VikunjaTests extends BaseTest {

    @Test(dataProvider = "loginTestData")
    public void testVikunja(String testcase, String userName, String email, String password, String expectedMessage) {
        try {
            Reporter.log("Test Case ::: " + testcase);
            openSite(VIKUNJA_REGISTER_URL);
            RegisterPage registerPage = new RegisterPage(driver);
            String actualMessage = registerPage.registerAccount(testcase, userName, email, password);
            Reporter.log("Actual Message ::: " + actualMessage);
            Reporter.log("Expected Message ::: " + expectedMessage);
            Assert.assertTrue(actualMessage.contains(expectedMessage));
        } catch (Exception e) {
            Reporter.log(e.getMessage());
        }
    }
}
