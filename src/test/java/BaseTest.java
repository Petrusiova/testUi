
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.BasePage;
import pages.CategoryPage;
import pages.MainPage;

public class BaseTest {
    @BeforeEach
    @Step("Открываем стартовую страницу и выбираем произвольную категорию")
    public void beforeScenario(){
        try {
            preparePostsList();
        } catch (IllegalArgumentException e){
            preparePostsList();
        }
    }

    public static void preparePostsList() {
        MainPage mainPage = new MainPage();
        mainPage.chooseCategory();

        CategoryPage categoryPage = new CategoryPage();
        categoryPage.chooseCategory();
        categoryPage.chooseCategory();

        categoryPage.checkFavourites(0);
    }

    @AfterEach
    @Step("Закрыть браузер")
    public void finish() {
        new BasePage().afterScenario();
    }
}
