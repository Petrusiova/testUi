package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFormPage extends BasePage{

    @FindBy(name = "s_andlike_txt_bigtext")
    WebElement input;

    @Step("Enter {search} to input field and press ENTER")
    public void search(String search){
        input.click();
        input.clear();
        input.sendKeys(search);
        input.sendKeys(Keys.ENTER);
    }
}
