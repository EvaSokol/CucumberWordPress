package pageObjects;


import core.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Eva Sokolyanskaya on 12/11/2015.
 */
public class AllPostsPage extends WebDriverActions {

    @FindBy(xpath = ".//*[@id='wpbody-content']//h1[contains(text(), 'Posts')]")
    public WebElement allPostsPage;

    @FindBy(xpath = ".//*[@id='bulk-action-selector-top']")
    private WebElement bulkActions;

    @FindBy(xpath = ".//*[@id='posts-filter']//span[@class='displaying-num']")
    private WebElement number;

//    @FindBy(xpath = ".//*[@id='screen-options-apply']")
//    private WebElement applyButton;

//    .//*[@id='posts-filter']//span[@class='displaying-num']

    public boolean isNumberChanged(){
        String data = driver.findElement(By.xpath(".//*[@id='posts-filter']//span[@class='displaying-num']")).getText();
        Integer number = Integer.parseInt(data.split(" ")[0]);
        number--;
        String newData = number.toString();
        waitForElementText(By.xpath(".//*[@id='posts-filter']//span[@class='displaying-num']"), newData);
        return true;
    }

    public void moveToTrash() throws InterruptedException {
        mouseClick(bulkActions);
        WebElement trashOption = driver.findElement(By.xpath(".//*[@id='bulk-action-selector-top']/option[@value='trash']"));
//        mouseMoveTo(trashOption);
//        mouseClick(trashOption);
//        mouseMoveTo(applyButton);

//
        Actions action= new Actions(driver);
        action.click(trashOption).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();


        waitForElementEnabled(By.xpath(".//*[@id='doaction']"));
//        waitForElementEnabled(By.xpath(".//*[@value='Apply']"));
//        WebElement applyButton = driver.findElement(By.xpath(".//*[@value='Apply']"));
        WebElement applyButton = driver.findElement(By.xpath(".//*[@id='doaction']"));
        applyButton.click();

//        mouseClick(applyButton);
//        applyButton.click();
//        Wait<WebDriver> wait = new WebDriverWait(driver, 30);

    }

//    public WebElement currentPostCheckBox = driver.findElement(By.xpath(".//th/*[contains(text(), 'qwerty')]/../input[@type='checkbox']"));

    public WebElement currentPostCheckBox (String title) {
        WebElement currentPostCheckBox = driver.findElement(By.xpath(".//th/*[contains(text(), '" + title + "')]/../input[@type='checkbox']"));


        return currentPostCheckBox;
    }
}
