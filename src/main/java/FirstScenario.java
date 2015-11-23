import core.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Eva Sokolyanskaya on 23/11/2015.
 */
public class FirstScenario extends BaseTest{

    @Given("^user opens 'New Post' page$")
    public void createSimplePost() {
        loginPage.open();
        loginPage.setUerName();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        userMenu.mouseMoveTo(userMenu.posts);
        userMenu.initAddNewPostLink().click();
    }

    @And("^user specifies (.*)$")
    public void userSpecifiesPostTitle(String title) {
        addNewPostPage.setMessageTitle(title);
    }

    @And("^user specifies post body$")
    public void userSpecifiesPostBody() {
        addNewPostPage.setMessageBody(messageText);
    }

    @When("^user clicks 'Publish' button$")
    public void userClicksPublishButton() {
        addNewPostPage.clickOnPublishButton();
    }

    @Then("^post should be added to the wordpress$")
    public void postShouldBeAddedToTheWordpress() {

    }
}
