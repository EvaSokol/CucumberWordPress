package pageObjects;

import core.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Eva Sokolyanskaya on 12/11/2015.
 * Page objects for Add New Post page
 */
public class AddNewPostPage extends WebDriverActions {

    @FindBy(xpath = ".//div[@id='wpbody-content']/div[@class='wrap']/h1")
    public WebElement addNewPostPageActive;

    @FindBy(xpath = ".//label[@id='title-prompt-text']")
    public WebElement titleField;

    @FindBy(xpath = ".//input[@id='publish']")
    public WebElement publishButton;

    public void setMessageTitle(String title) {
        titleField.sendKeys(title);
    }

    public void setMessageBody(String messageText) {
        driver.switchTo().frame("content_ifr");
        driver.switchTo().activeElement().sendKeys(messageText);
        driver.switchTo().defaultContent();
    }

    public void clickOnPublishButton() {
        waitForElementEnabled(By.xpath(".//input[@id='publish']"));
        publishButton.click();
    }
}
