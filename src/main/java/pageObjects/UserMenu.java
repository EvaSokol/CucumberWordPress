package pageObjects;

import core.ApplicationSettings;
import core.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 * Page object for common user menu.
 */
public class UserMenu extends WebDriverActions {

    @FindBy(xpath = ".//li[@id='wp-admin-bar-my-account']/a")
    public WebElement loggedIn;

    @FindBy(xpath = ".//li[@id='menu-posts']/a/div[@class='wp-menu-name']")
    public WebElement posts;

    @FindBy(xpath = ".//li[@id='menu-posts']/ul/li/a[@class='wp-first-item current']")
    public WebElement allPosts;

    @FindBy(xpath = ".//*[@id='wp-admin-bar-edit']/a")
    public WebElement editPost;


    public WebElement addNewPost;

    public boolean isLoggedIn() {
        String howdy = "Howdy, " + ApplicationSettings.userName;
        if (isElementPresented(loggedIn) &&
                isElementContainsText(loggedIn, howdy))
            return true;
        else return false;
    }

    public WebElement initAddNewPostLink() {
        addNewPost = (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath(
                ".//*[@id='menu-posts']/ul/li/a[@href='post-new.php']")));
        return addNewPost;
    }

//    public WebElement allPosts() {
//        return driver.findElement(By.xpath(".//li[@id='menu-posts']//a[@class='wp-first-item current']"));
//    }
}
