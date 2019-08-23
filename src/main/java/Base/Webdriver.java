package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriver {
    private static WebDriver driver;
public static WebDriver getDriver(){
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
    if(driver == null) {
        driver = new ChromeDriver();
    }
    return driver;
}
}
