package pageObjects;


import core.WebDriverActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Eva Sokolyanskaya on 12/11/2015.
 */
public class ViewPostPage extends WebDriverActions {

    @FindBy(xpath = ".//article/header/h1[@class='entry-title']")
    public WebElement postTitle;

    @FindBy(xpath = ".//article/div[@class='entry-content']/p")
    public WebElement postBody;
}
