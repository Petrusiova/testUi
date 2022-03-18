import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ItemPage;
import pages.PostsPage;


@DisplayName("Scenario: add to favourites via opening item's page and pressing the 'Add to favourites' button")
public class ItemTest extends BaseTest{

    @Test
    @DisplayName("Save 1 item to favourites")
    public void simpleAddTest() {
        new PostsPage().clickItem(1);
        new ItemPage().addToFavs(0, 1);
    }

    @Test
    @DisplayName("Save several items to favourites")
    public void bulkAddTest() {
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
    @DisplayName("Save 1 item to favourites and delete from favourites")
    public void simpleAddAndDeleteTest() {
        new PostsPage().clickItem(1);
        new ItemPage().deleteFromFavs(0);
    }

    @Test
    @DisplayName("Save several items to favourites and delete all of them from favourites")
    public void bulkAddDeleteTest() {
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
