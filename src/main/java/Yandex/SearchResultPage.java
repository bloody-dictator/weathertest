package Yandex;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "(//li[@class='place-list__item']/a)[1]")
    private WebElement firstSearchResult;

    public void clickFirstSearchResult() {
        firstSearchResult.click();
    }

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}
