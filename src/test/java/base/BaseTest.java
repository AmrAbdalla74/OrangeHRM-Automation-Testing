package base;
import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setup() {
        DriverFactory.setupDriver(config.getProperty("browser"));
        DriverFactory.getDriver().get(config.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
