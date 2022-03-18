package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"categories\"]//li//a")
    private List<WebElement> categoryVariety;

    @FindBy(xpath = "//a[contains(text(), 'Расширенный поиск')]")
    private WebElement wideSearch;

    @Step("Choose random category with >= 1 result")
    public void chooseCategory(){
        Assertions.assertNotNull(categoryVariety, "No categories on page");
        if (categoryVariety.size() > 0) {

            List<WebElement> elementList = new ArrayList<>();

            for (int i = 1; i <= categoryVariety.size(); i++) {
                boolean b = false;
                try {
                    b = Integer.parseInt(getChromeDriver().findElement(By.xpath("//*[@id=\"categories\"]//li[" + i + "]//a/../..//span")).getText()
                            .replaceAll("\\(", "").replaceAll("\\)", "")) >= 2;
                } catch (Exception e){

                }
                if(b){
                    elementList.add(categoryVariety.get(i));
                }
            }
            chooseRandomCategory(elementList);
        }
    }

    @Step("Click the 'wide search' button")
    public void wideSearch(){
        wideSearch.click();
    }
}
