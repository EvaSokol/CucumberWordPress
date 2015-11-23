package pageObjects;

import core.WebDriverActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Eva Sokolyanskaya on 12/11/2015.
 * Page object for Edit Post page.
 */
public class EditPostPage extends WebDriverActions {

    @FindBy(xpath = ".//div[@id='wpbody-content']/div[@class='wrap']/h1")
    public WebElement editNewPostPageActive;

    @FindBy(xpath = ".//div[@id='message']/p/a")
    public WebElement viewPost;
}
