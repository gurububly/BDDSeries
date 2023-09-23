package driver;

import enums.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.PropertyUtils;

import java.util.Objects;

public class Driver {

    private Driver() {

    }

    public static void initDriver() throws Exception {

        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriver driver = new ChromeDriver();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyUtils.getProperty(ConfigProperties.URL));
        }

    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }
}
