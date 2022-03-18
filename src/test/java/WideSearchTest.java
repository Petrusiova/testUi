
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import pages.*;

import java.awt.*;

@DisplayName("Scenario: add to favourites from wide search via tapping the 'heart' button")
public class WideSearchTest {

    @BeforeEach
    @Step("Open the wide search and input 'auto' (ru)")
    public void prepareWistViaWideSearch() {
        new MainPage();
        new CategoryPage().wideSearch();
        new SearchFormPage().search("авто");
    }

    @Test
    @DisplayName("Save 1 item to favourites")
    public void simpleAddTest() throws AWTException {
        new PostsPage().saveToFavourites();
    }

    @Test
    @DisplayName("Save 1 item to favourites and delete from favourites")
    public void simpleDeleteFromFavs() throws AWTException {
        new PostsPage().deleteFromFavourites();
    }

    @Test
    @DisplayName("Save several items to favourites")
    public void bulkAddToFavs() throws AWTException {
        new PostsPage().saveToFavouritesBulk();
    }

    @Test
    @DisplayName("Save several items to favourites and delete all of them from favourites")
    public void bulkDeleteFromFavs() throws AWTException {
        new PostsPage().deleteFromFavouritesBulk();
    }

    @AfterEach
    public void finish() {
       new BasePage().afterScenario();
    }
}
