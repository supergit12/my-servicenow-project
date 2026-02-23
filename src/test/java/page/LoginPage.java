package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	    WebDriver driver;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By username = By.id("user_name");
	    By password = By.id("user_password");
	    By loginBtn = By.id("sysverb_login");
	    By errorMsg = By.id("error_text");

	    public void login(String user, String pass) {

	        driver.findElement(username).sendKeys(user);

	        driver.findElement(password).sendKeys(pass);

	        driver.findElement(loginBtn).click();
	    }

	    public String getErrorMessage() {
	        return driver.findElement(errorMsg).getText();
	    }
	}


