package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("user_name");
    By password = By.id("user_password");
    By loginBtn = By.id("sysverb_login");
    By errorMsg = By.xpath("//*[contains(@class,'outputmsg')]");   

    public void login(String user, String pass) {

        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMsg)
        );

        return error.getText();
    }
}




