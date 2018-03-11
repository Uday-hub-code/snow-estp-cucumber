package com.disney.cast.platform.estp.test;

import static com.disney.cast.platform.estp.test.ui.UiAuthLevel.SNOWADMIN;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.disney.automation.webframework.config.User;
import com.disney.automation.webframework.webdriver.Drivers;
import com.disney.cast.platform.estp.test.ui.AbstractEstpUiTest;
import com.disney.cast.platform.estp.ui.app.pages.ApplicationsLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ru.yandex.qatools.allure.annotations.Attachment;

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
        ApplicationsLoginPage loginPage = new ApplicationsLoginPage();
        Thread.sleep(5000);
        // HomePage homePage = loginPage.logIn(planner.getUserName(), planner.getPass(),
        // HomePage.class);

        // assertTrue("Planner should have been able to log in. Home page is not displayed",
        // homePage.isVisible());
        makeScreenshotOnFailure();
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

    @Attachment("Screenshot")
    public byte[] makeScreenshotOnFailure() {
        return ((TakesScreenshot) Drivers.INSTANCE.get()).getScreenshotAs(OutputType.BYTES);
    }

}
