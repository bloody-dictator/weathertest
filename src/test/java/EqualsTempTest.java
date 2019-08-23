
import Gismeteo.GismeteoPage;
import Yandex.YandexTenDaysWeatherPage;
import Yandex.YandexWeatherPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Base.Webdriver.getDriver;
import static Gismeteo.GismeteoPage.gismeteoTemps;
import static Yandex.YandexTenDaysWeatherPage.yandexTemps;

public class EqualsTempTest {
    @Test
    public void secondTest() {
        getDriver().get("https://yandex.ru/pogoda");
        YandexWeatherPage yandexWeatherPage = new YandexWeatherPage(getDriver());
        yandexWeatherPage.typeSearchcity("Томск").clickFirstSearchResult();
        yandexWeatherPage.clickTodayWeather(yandexWeatherPage.getWeathercards())
                .getDayTemp(new YandexTenDaysWeatherPage(getDriver()).getDayTemps());
        getDriver().get("https://www.gismeteo.ru/");
        GismeteoPage gismeteoPage = new GismeteoPage(getDriver());
        gismeteoPage.typeSeachcity("Томск");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gismeteoPage.clickTenDays();
        gismeteoPage.getTextTemp(gismeteoPage.getTempValue());

        for (int i = 0; i < yandexTemps.size(); i++) {
            Assert.assertTrue(yandexTemps.get(i).equals(gismeteoTemps.get(i)), "Температуры по дням не совпадают"); {
            }
        }
    }
}
