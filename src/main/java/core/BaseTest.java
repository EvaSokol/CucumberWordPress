package core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.*;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 * Class to inheritance for all tests.
 */
public class BaseTest {

    protected static WebDriver driver = WebDriverActions.getDriver();
    protected LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    protected UserMenu userMenu = PageFactory.initElements(driver, UserMenu.class);
    protected AddNewPostPage addNewPostPage = PageFactory.initElements(driver, AddNewPostPage.class);
    protected EditPostPage editPostPage = PageFactory.initElements(driver, EditPostPage.class);
    protected ViewPostPage viewPostPage = PageFactory.initElements(driver, ViewPostPage.class);
    protected AllPostsPage allPostsPage = PageFactory.initElements(driver, AllPostsPage.class);

    public static String title;
    public static String messageText;

    @BeforeTest
    public void setUp() {
        title = "qwertyTitle" + (int)(Math.random()*1000);
        messageText = "qwertyText" + (int)(Math.random()*1000);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
