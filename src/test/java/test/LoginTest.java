package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import page.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() throws Exception {
        return ExcelUtility.getTestData(
                "src/test/resources/testdata/LoginData.xlsx",
                "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedResult) {

        LoginPage lp = new LoginPage(driver);

        lp.login(username, password);


        if (expectedResult.equalsIgnoreCase("valid")) {

            // 🔹 Explicit Wait for Title
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.titleContains("ServiceNow"));

            String actualTitle = driver.getTitle();
            System.out.println("Home Page Title: " + actualTitle);

            Assert.assertTrue(actualTitle.contains("ServiceNow"),
                    "Home page title validation FAILED");
        } else {

            // Invalid login → error message displayed
            Assert.assertTrue(driver.getCurrentUrl().contains("login")
                    || lp.getErrorMessage().length() > 0);
        }
    }
}


