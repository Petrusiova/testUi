package pages;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@class=\"categories\"]//li")
    private List<WebElement> categoriesList;

    public MainPage() {
        getChromeDriver().get(MAIN_PAGE_URL);
    }

    @Step("Выбор произвольной категории")
    public void chooseCategory(){
        checkExpectedUrl(MAIN_PAGE_URL);
        Assertions.assertNotNull(categoriesList,"No categories on page");
        List<WebElement> list = categoriesList.stream().filter(item -> Integer.parseInt(item.findElement(By.xpath("//a/span")).getText()
                        .replaceAll("\\(", "").replaceAll("\\)", "")) >= 3)
                .collect(Collectors.toList());
        chooseRandomCategory(list);
    }



}
