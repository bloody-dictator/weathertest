package Yandex;

import Base.BasePage;
import Base.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexWeatherPage extends BasePage {

    @FindBy(xpath = "//input[@class='input__control']")
    private WebElement inputSearch;

    @FindBy(xpath = "//div[contains(@class, 'forecast-briefly__day swiper-slide')]")
    private List<WebElement> weathercards;

    String weatherTempValue = "./a/div/span[@class='temp__value']";
    String weatherNameDay = "./a/div[@class='forecast-briefly__name']";



    public List<WebElement> getWeathercards() {
        return weathercards;
    }

    public YandexWeatherPage(WebDriver driver){
        super(driver);
    }

    public SearchResultPage typeSearchcity(String city){
        inputSearch.sendKeys(city);
        inputSearch.sendKeys(Keys.ENTER);
        return new SearchResultPage(Webdriver.getDriver());
    }

    public YandexTenDaysWeatherPage clickTodayWeather(List<WebElement> weathercards){
        for (WebElement weathercard: weathercards) {
            if(weathercard.findElement(By.xpath(weatherNameDay)).getText().equals("Сегодня")){
                weathercard.click();
                break;
            }
        }
        return new YandexTenDaysWeatherPage(Webdriver.getDriver());
    }


}
