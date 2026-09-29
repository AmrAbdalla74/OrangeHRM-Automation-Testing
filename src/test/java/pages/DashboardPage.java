package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Wait;

public class DashboardPage {

    private WebDriver driver;

    private By UserDropDown = By.cssSelector(".oxd-userdropdown-name");
    private By logoutBtn = By.linkText("Logout");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickUserDropDown() {
        Wait wait = new Wait(driver);
        wait.waitForClickable(UserDropDown).click();
    }

    public void clickLogoutBtn() {
        Wait wait = new Wait(driver);
        wait.waitForClickable(logoutBtn).click();
    }
}
