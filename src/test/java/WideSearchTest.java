
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import pages.*;

import java.awt.*;

@DisplayName("Сценарий: добавление в избранное из расширенного поиска, нажав на 'сердечко'")
public class WideSearchTest {

    @BeforeEach
    @Step("Переходим в расширенный поиск и ищем 'авто'")
    public void prepareWistViaWideSearch() {
        new MainPage();
        new CategoryPage().wideSearch();
        new SearchFormPage().search("авто");
    }

    @Test
    @DisplayName("Сохранить 1 предложение в избранное")
    public void simpleAddTest() throws AWTException {
        new PostsPage().saveToFavourites();
    }

    @Test
    @DisplayName("Сохранить 1 предложение в избранное и удалить из избранного")
    public void simpleDeleteFromFavs() throws AWTException {
        new PostsPage().deleteFromFavourites();
    }

    @Test
    @DisplayName("Сохранить несколько предложений в избранное")
    public void bulkAddToFavs() throws AWTException {
        new PostsPage().saveToFavouritesBulk();
    }

    @Test
    @DisplayName("Сохранить несколько предложений в избранное и удалить из избранного")
    public void bulkDeleteFromFavs() throws AWTException {
        new PostsPage().deleteFromFavouritesBulk();
    }

    @AfterEach
    public void finish() {
       new BasePage().afterScenario();
    }
}
