package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\CucumberRahulFramework\\FrameworkPracticeBDD\\src\\test\\resources\\features",
        glue = {"stepdefinition"},
        dryRun = false
        , monochrome = true


)
public class TestRunner extends AbstractTestNGCucumberTests {
}
