import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ItemPage;
import pages.PostsPage;

import java.awt.*;


@DisplayName("Сценарий: добавление в избранное, пролистав до конца и нажав на кнопку 'Добавить в избранное'")
public class ItemTest extends BaseTest{

    @Test
    @DisplayName("Сохранить 1 предложение в избранное")
    public void simpleAddTest() throws AWTException {
        new PostsPage().clickItem(1);
        new ItemPage().addToFavs(0, 1);
    }

    @Test
    @DisplayName("Сохранить несколько предложений в избранное")
    public void bulkAddTest() throws AWTException {
        PostsPage postsPage = new PostsPage();
        postsPage.clickItem(1);
        ItemPage itemPage = new ItemPage();
        itemPage.addToFavs(0, 1);
        itemPage.back();
        postsPage.clickItem(2);
        itemPage = new ItemPage();
        itemPage.addToFavs(1, 2);
    }

    @Test
    @DisplayName("Сохранить 1 предложение в избранное и удалить из избранного")
    public void simpleAddAndDeleteTest() throws AWTException {
        new PostsPage().clickItem(1);
        new ItemPage().deleteFromFavs(0);
    }

    @Test
    @DisplayName("Сохранить несколько предложений в избранное и удалить из избранного")
    public void bulkAddDeleteTest() throws AWTException {
        PostsPage postsPage = new PostsPage();
        postsPage.clickItem(1);
        ItemPage itemPage = new ItemPage();
        itemPage.addToFavs(0, 1);
        itemPage.back();
        postsPage.clickItem(2);
        itemPage = new ItemPage();
        itemPage.deleteFromFavs(1);
    }
}
