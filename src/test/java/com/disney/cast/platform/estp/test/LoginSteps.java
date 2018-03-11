package com.disney.cast.platform.estp.test;

import static com.disney.cast.platform.estp.test.ui.UiAuthLevel.SNOWADMIN;

import java.net.MalformedURLException;

import com.disney.automation.webframework.config.User;
import com.disney.cast.platform.estp.test.ui.AbstractEstpUiTest;
import com.disney.cast.platform.estp.ui.app.pages.ApplicationsLoginPage;

import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginSteps extends AbstractEstpUiTest {

    public LoginSteps() throws MalformedURLException {
        super();
    }

    private final User planner = users().get(SNOWADMIN.toString());

    @Given("^Login page is displayed$")
    public void login_page_is_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^Enter valid credentials$")
    public void enter_valid_credentials() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Welcome page is displayed$")
    public void welcome_page_is_displayed() throws Throwable {
        new ApplicationsLoginPage();
        Thread.sleep(2000);
        attachScreenshot();
    }

    @Given("^Enter invalid username and valid password$")
    public void enter_invalid_username_and_valid_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Wrong user message is displayed$")
    public void wrong_user_message_is_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^Enter valid username and invalid password$")
    public void enter_valid_username_and_invalid_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Wrong password message is displayed$")
    public void wrong_password_message_is_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @But("^I should see an error here$")
    public void i_should_see_an_error_here() {
        // Write code here that turns the phrase above into concrete actions
        throw new NullPointerException("Fix me!");
    }

}
