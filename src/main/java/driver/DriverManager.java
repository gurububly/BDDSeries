package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {


    private DriverManager() {

    }

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void setDriver(WebDriver localDriver) {
        threadLocal.set(localDriver);
    }

    public static void unloadDriver() {
        threadLocal.remove();
    }

}
