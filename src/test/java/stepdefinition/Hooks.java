package stepdefinition;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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
}
