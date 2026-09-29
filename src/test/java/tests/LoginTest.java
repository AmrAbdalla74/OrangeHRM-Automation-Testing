package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import static factory.DriverFactory.driver;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private ConfigReader config;
    private DashboardPage dashboardPage;
    @BeforeMethod
    public void setupPages(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        config = new ConfigReader();
    }

    //login with valid data (username & password)
    @Test
    public void ValidLogin(){
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );
    }

    // login with invalid Username
    @Test
    public void InvalidUsernameLogin(){
        loginPage.login(
                config.getProperty("invalidUser"),
                config.getProperty("password")
        );
        String InvalidText = loginPage.getInvalidLoginText();
        Assert.assertEquals(InvalidText , "Invalid credentials");
    }

    // login with invalid Password
    @Test
    public void InvalidPasswordLogin(){
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("invalidPass")
        );
        String InvalidText = loginPage.getInvalidLoginText();
        Assert.assertEquals(InvalidText , "Invalid credentials");
    }

    @Test
    public void EmptyUsernameLogin(){
        loginPage.login(
                "" ,
                config.getProperty("password"));
        String usernameRequiredText = loginPage.getUsernameRequiredText();
        Assert.assertEquals(usernameRequiredText , "Required");
    }

    @Test
    public void EmptyPasswordLogin(){
        loginPage.login(
                config.getProperty("username"),
                "");
        String PasswordRequiredText = loginPage.getPasswordRequiredText();
        Assert.assertEquals(PasswordRequiredText , "Required");
    }

    //Logout
    @Test
    public void Logout(){
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );
        dashboardPage.clickUserDropDown();
        dashboardPage.clickLogoutBtn();
        String LoginTitle = loginPage.getLoginTitle();
        Assert.assertEquals(LoginTitle , "Login");
    }

}
