import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PostsPage;

import java.awt.*;

@DisplayName("Scenario: add to favourites via tapping the 'heart' button")
public class ListTest extends BaseTest{

    @Test
    @DisplayName("Save 1 item to favourites")
    public void simpleAddToFavs() throws AWTException {
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
}
