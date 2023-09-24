package stepdefinition;

import driver.Driver;
import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {


    @Before
    public static void setup() throws Exception {
        System.out.println("Before");
        Driver.initDriver();

    }

    @After
    public static void tearDown() {
        System.out.println("After");
        Driver.quitDriver();

    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            File sourceFilePath = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                byte[] fileContent = FileUtils.readFileToByteArray(sourceFilePath);
                scenario.attach(fileContent, "image/png", "image");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
