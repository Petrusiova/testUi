import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PostsPage;

import java.awt.*;

@DisplayName("Сценарий: добавление в избранное, нажав на 'сердечко'")
public class ListTest extends BaseTest{

    @Test
    @DisplayName("Сохранить 1 предложение в избранное")
    public void simpleAddToFavs() throws AWTException {
        new PostsPage().saveToFavourites();
    }

    @Test
    @DisplayName("Сохранить 1 предложение в избранное и удалить его")
    public void simpleDeleteFromFavs() throws AWTException {
        new PostsPage().deleteFromFavourites();
    }

    @Test
    @DisplayName("Сохранить несколько предложений в избранное")
    public void bulkAddToFavs() throws AWTException {
        new PostsPage().saveToFavouritesBulk();
    }

    @Test
    @DisplayName("Сохранить несколько предложений в избранное и удалить их")
    public void bulkDeleteFromFavs() throws AWTException {
        new PostsPage().deleteFromFavouritesBulk();
    }


}
