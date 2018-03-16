package com.disney.cast.platform.estp.test.ui;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import com.disney.automation.webframework.config.User;
import com.disney.automation.webframework.visual.comparator.OcularResult;
import com.disney.cast.platform.estp.ui.app.pages.ApplicationsLoginPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginSteps extends AbstractEstpUiTest {

    public LoginSteps() throws MalformedURLException {
        super();
    }

    private final User planner = users().get(UiAuthLevel.PLANNER.toString());
    private ApplicationsLoginPage loginPage;

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
        loginPage = new ApplicationsLoginPage();
        Thread.sleep(5000);
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

    @Then("^validateScreenshot$")
    public void validatescreenshot() {
        OcularResult ocularResult = loginPage.compare();
        assertTrue("Images should be equals", ocularResult.isEqualsImages());
    }

    @Then("^testPasses$")
    public void testPasses() {
        assertTrue(true);
    }

    @Then("^testDontPass$")
    public void testDontPass() {
        assertTrue(false);
    }

    @After("@Visual")
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            attachResultImage(scenario.getName());
            attachSampleImage(scenario.getName());
            attachSnapshotImage(scenario.getName());
        } else {
            attachSampleImage(scenario.getName());
        }
        System.out.println("Finished running scenario: " + scenario.getName());
    }

}
