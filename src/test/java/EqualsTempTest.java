
import Base.BaseTest;
import Gismeteo.GismeteoPage;
import Yandex.YandexTenDaysWeatherPage;
import Yandex.YandexWeatherPage;
import org.testng.Assert;
import org.testng.annotations.Test;


import static Base.Webdriver.getDriver;
import static Gismeteo.GismeteoPage.gismeteoTemps;
import static Yandex.YandexTenDaysWeatherPage.yandexTemps;
import static utils.PropertyLoader.getProperties;

public class EqualsTempTest extends BaseTest {
    @Test
    public void secondTest() {
        getDriver().get(getProperties("yandexweather.url"));
        YandexWeatherPage yandexWeatherPage = new YandexWeatherPage(getDriver());
        yandexWeatherPage.typeSearchcity("Томск").clickFirstSearchResult();
        implicitWaits(10);
        yandexWeatherPage.clickTodayWeather(yandexWeatherPage.getWeathercards())
                .getDayTemp(new YandexTenDaysWeatherPage(getDriver()).getDayTemps());
        getDriver().get(getProperties("gismeteo.url"));
        GismeteoPage gismeteoPage = new GismeteoPage(getDriver());
        gismeteoPage.typeSeachcity("Томск");
        implicitWaits(10);
        gismeteoPage.clickTenDays().getTextTemp(gismeteoPage.getTempValue());

        for (int i = 0; i < yandexTemps.size(); i++) {
            Assert.assertTrue(yandexTemps.get(i).equals(gismeteoTemps.get(i)), "Температуры по дням не совпадают");
        }
    }
}
