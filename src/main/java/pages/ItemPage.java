package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemPage extends BasePage{

    @FindBy(id = "favs-link")
    WebElement favsLink;

    @FindBy(xpath = "//a[@onclick=\"return checkBackUrl()\"]")
    List<WebElement> back;

    @Step("Click the 'add to favourites' button")
    public void addToFavs(int expectedFavsStart, int expectedFavsFinish) {
        checkFavourites(expectedFavsStart);
        favsLink.click();
        checkFavourites(expectedFavsFinish);
    }

    @Step("Click the 'delete from favourites' button")
    public void deleteFromFavs(int start) {
        checkFavourites(start);
        favsLink.click();
        checkFavourites(start + 1);
        favsLink.click();
        checkFavourites(start);
    }

    @Step("Back to the previous page")
    public void back(){
        back.get(0).click();
    }
}
