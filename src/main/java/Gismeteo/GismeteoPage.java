package Gismeteo;

import Base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GismeteoPage extends BasePage {
    public static ArrayList<String> gismeteoTemps = new ArrayList<String>();

    @FindBy(xpath = "//input[@type='search']")
    private WebElement inputSearch;

    @FindBy(xpath = "//div[@class='maxt']/span[contains(@class, 'unit_temperature_c')]")
    private List<WebElement> tempValue;

    @FindBy(xpath = "//a[contains(text(), '10 дней')]")
    private WebElement tenDays;

    public List<WebElement> getTempValue() {
        return tempValue;
    }

    public GismeteoPage(WebDriver driver) {
        super(driver);
    }

    public GismeteoPage typeSeachcity(String city) {
        inputSearch.sendKeys(city);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }

    public GismeteoPage clickTenDays() {
        tenDays.click();
        return this;
    }

    public List<String> getTextTemp(List<WebElement> temps) {
        int i = 0;
        for (WebElement temp : temps) {
            gismeteoTemps.add(temp.getText());
            i++;
            if (i == 7) {
                break;
            }
        }
        System.out.println(gismeteoTemps);
        return gismeteoTemps;
    }
}
