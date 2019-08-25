package Base;

import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import static Base.Webdriver.getDriver;

public class BaseTest {
    @AfterTest
    public static void afterTest() {
        Webdriver.getDriver().quit();
    }

    public static void implicitWaits(int seconds) {
        getDriver().manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
    }
}
