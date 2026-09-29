package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Wait;

public class LoginPage {

    private WebDriver driver;

    private By loginTitle = By.className("orangehrm-login-title");
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginBtn = By.className("orangehrm-login-button");
    private By invalidLoginText = By.cssSelector(".oxd-alert-content-text");
    private By usernameRequiredText = By.xpath(
            "//label[normalize-space()='Username']" +
                    "/ancestor::div[contains(@class,'oxd-input-group')]" +
                    "//span[contains(@class,'oxd-input-field-error-message')]"
    );
    private By PasswordRequiredText = By.xpath(
            "//label[normalize-space()='Password']" +
                    "/ancestor::div[contains(@class,'oxd-input-group')]" +
                    "//span[contains(@class,'oxd-input-field-error-message')]"
    );

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        Wait wait = new Wait(driver);

        wait.waitFotVisibility(usernameInput).sendKeys(username);
        wait.waitFotVisibility(passwordInput).sendKeys(password);
        wait.waitForClickable(loginBtn).click();
    }

    public String getInvalidLoginText() {
        Wait wait = new Wait(driver);
        return wait.waitFotVisibility(invalidLoginText).getText();
    }

    public String getLoginTitle() {
        Wait wait = new Wait(driver);
        return wait.waitFotVisibility(loginTitle).getText();
    }

    public String getUsernameRequiredText() {
        return driver.findElement(usernameRequiredText).getText();
    }

    public String getPasswordRequiredText() {
        return driver.findElement(PasswordRequiredText).getText();
    }
}

