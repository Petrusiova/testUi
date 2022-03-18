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

    @Step("Нажать на кнопку добавления в избранное")
    public void addToFavs(int expectedFavsStart, int expectedFavsFinish) {
        checkFavourites(expectedFavsStart);
        favsLink.click();
        checkFavourites(expectedFavsFinish);
    }

    @Step("Нажать на кнопку удаления из избранного")
    public void deleteFromFavs(int start) {
        checkFavourites(start);
        favsLink.click();
        checkFavourites(start + 1);
        favsLink.click();
        checkFavourites(start);
    }

    @Step("Вернуться на предыдущую страницу")
    public void back(){
        back.get(0).click();
    }
}
