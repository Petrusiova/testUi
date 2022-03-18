package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class BasePage {

    private static ChromeDriver driver;
    public static final String MAIN_PAGE_URL = "https://www.reklama.lv/ru/";
    Actions actions;

    public BasePage() {
        initWebDriver();
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public static ChromeDriver getChromeDriver() {
        return driver;
    }

    private void initWebDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/resources/webdrivers/chromedriver");
            driver = new ChromeDriver();
        }
    }

    @AfterEach
    @Step("Закрыть браузер")
    public void afterScenario() {
        driver.close();
        driver.quit();
        driver = null;
    }

    @Step("Проверить url на соответствие ожидаемому: {expectedUrl}")
    public static void checkExpectedUrl(String expectedUrl){
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl(), "Wrong page url");
    }

    public void chooseRandomCategory(List<WebElement> elementsList) {
        int categoriesSize = elementsList.size();
        Random random = new Random();
        int categoryNumber = Math.abs(random.nextInt(categoriesSize - 1));
        while (categoryNumber <= 0){
            categoryNumber = Math.abs(random.nextInt(categoriesSize - 1));
        }
        elementsList.get(categoryNumber).click();
    }

    @Step("Нажать на элемент")
    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (WebDriverException e) {
            JavascriptExecutor executor = (JavascriptExecutor) getChromeDriver();
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            executor.executeScript("arguments[0].click()", element);
        }
    }

    @Step("Проверить количество предложений в избранном: {expected}")
    public void checkFavourites(int expected) {
        int favorites_count = Integer.parseInt(getChromeDriver().findElement(By.id("favorites_count")).getText());
        Assertions.assertEquals(expected, favorites_count, "Actual favs count != expected");
    }
}
