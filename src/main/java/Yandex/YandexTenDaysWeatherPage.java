package Yandex;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class YandexTenDaysWeatherPage extends BasePage {
    public static ArrayList<String> yandexTemps = new ArrayList<String>();

    @FindBy(xpath = "//div[@class='weather-table__wrapper']/div[contains(text(), 'днём')]")
    private List<WebElement> day;

    @FindBy(xpath = "//div[@class='weather-table__wrapper']/div[contains(text(), 'днём')]/../div[contains(@class,'weather-table__temp')]")
    private List<WebElement> dayTemps;

    public List<WebElement> getDayTemps() {
        return dayTemps;
    }

    public YandexTenDaysWeatherPage(WebDriver driver){
        super(driver);
    }

    public List<String> getDayTemp(List<WebElement> dayTemps){
        int i = 0;
        for(WebElement dayTemp: dayTemps){
            yandexTemps.add(dayTemp.getText().substring(0, dayTemp.getText().indexOf('°')));
            i++;
            if (i==7){
                break;
            }
        }
        System.out.println(yandexTemps);
        return yandexTemps;
    }
}
