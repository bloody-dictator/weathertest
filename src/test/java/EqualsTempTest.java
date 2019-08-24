
import Gismeteo.GismeteoPage;
import Yandex.YandexTenDaysWeatherPage;
import Yandex.YandexWeatherPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyLoader;

import java.util.concurrent.TimeUnit;

import static Base.Webdriver.getDriver;
import static Gismeteo.GismeteoPage.gismeteoTemps;
import static Yandex.YandexTenDaysWeatherPage.yandexTemps;

public class EqualsTempTest {
    @Test
    public void secondTest() {
        getDriver().get(PropertyLoader.getProperties("yandexweather.url"));
        YandexWeatherPage yandexWeatherPage = new YandexWeatherPage(getDriver());
        yandexWeatherPage.typeSearchcity("Томск").clickFirstSearchResult();
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        yandexWeatherPage.clickTodayWeather(yandexWeatherPage.getWeathercards())
                .getDayTemp(new YandexTenDaysWeatherPage(getDriver()).getDayTemps());
        getDriver().get(PropertyLoader.getProperties("gismeteo.url"));
        GismeteoPage gismeteoPage = new GismeteoPage(getDriver());
        gismeteoPage.typeSeachcity("Томск");
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        gismeteoPage.clickTenDays();
        gismeteoPage.getTextTemp(gismeteoPage.getTempValue());

        for (int i = 0; i < yandexTemps.size(); i++) {
            Assert.assertTrue(yandexTemps.get(i).equals(gismeteoTemps.get(i)), "Температуры по дням не совпадают");
            {
            }
        }
    }
}
