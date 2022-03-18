package pages;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;


public class PostsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"posts\"]/tbody/tr")
    private List<WebElement> postList;

    ChromeDriver chromeDriver = BasePage.getChromeDriver();


    @Step("Кликнуть на предложение")
    public void clickItem(int item){
        Assertions.assertNotNull( postList,"No posts on the page");
        try {
            WebElement post = chromeDriver.findElement(By.xpath("//*[@id=\"posts\"]/tbody/tr[" + item + "]"));
            post.click();
        } catch (NoSuchElementException e){

        }

    }

    @Step("Добавить несколько элементов в избранное")
    public int saveToFavouritesBulk() throws AWTException {
        Assertions.assertNotNull( postList, "No posts on the page");
        int size = postList.size();

        addMethod(size, chromeDriver, actions);
        checkFavourites(size);
        return size;
    }

    @Step("Удалить все элементы из избранного")
    public void deleteFromFavouritesBulk() throws AWTException {
        var size = saveToFavouritesBulk();

        for (int i = size; i > 0; i--) {
            WebElement post = chromeDriver.findElement(By.xpath("//*[@id=\"posts\"]/tbody/tr[" + i + "]"));
            actions.moveToElement(post).build().perform();

            WebElement cross = chromeDriver.findElement(By.xpath("//*[@id=\"posts\"]/tbody/tr[" + i + "]//a[@class=\"fav-remove\"]/img"));
            clickFav(cross);
            checkFavourites(i-1);
        }

        checkFavourites(0);
    }

    @Step("Сохранить в избранное")
    public void saveToFavourites() throws AWTException {
        Assertions.assertNotNull(postList, "No posts on the page");
        WebElement post = chromeDriver.findElement(By.xpath("//*[@id=\"posts\"]/tbody/tr[1]"));
        actions.moveToElement(post).build().perform();

        WebElement heart = chromeDriver.findElement(By.xpath("//*[@id=\"posts\"]/tbody/tr[1]//a[@class=\"fav-add\"]/img"));
        clickFav(heart);
        checkFavourites(1);
        
    }

    public void deleteFromFavourites() throws AWTException {
        saveToFavourites();
        WebElement post = chromeDriver.findElement(By.xpath("//*[@id=\"posts\"]/tbody/tr[1]"));
        actions.moveToElement(post).build().perform();
        WebElement cross = chromeDriver.findElement(By.xpath("//*[@id=\"posts\"]/tbody/tr[1]//a[@class=\"fav-remove\"]/img"));
        clickFav(cross);
        checkFavourites(0);
    }

    private void clickFav(WebElement heart) throws AWTException {
        Coordinates coordinates = ((RemoteWebElement) heart).getCoordinates();
        Robot robot = new Robot();
        robot.mouseMove(coordinates.onPage().getX(), coordinates.onPage().getY() + 120);
        robot.mousePress(0);
        clickElement(heart);
    }

    @Step("Навести мышкой на предложение и нажать на сердечко")
    private void addMethod(int size, ChromeDriver chromeDriver, Actions actions) throws AWTException {
        for (int i = 1; i <= size; i++) {
            WebElement post = chromeDriver.findElement(By.xpath("//*[@id=\"posts\"]/tbody/tr[" + i + "]"));
            actions.moveToElement(post).build().perform();

            WebElement heart = chromeDriver.findElement(By.xpath("//*[@id=\"posts\"]/tbody/tr[" + i + "]//a[@class=\"fav-add\"]/img"));
            clickFav(heart);
        }
    }
}
