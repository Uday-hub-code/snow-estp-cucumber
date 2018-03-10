package com.disney.cast.platform.estp.test;

import java.net.MalformedURLException;

import com.disney.automation.servicetesting.core.ApiTestResponse;
import com.disney.cast.platform.estp.api.snow.tables.AlertTableApi;
import com.disney.cast.platform.estp.test.api.AbstractEstpApiTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ru.yandex.qatools.allure.annotations.Attachment;

public class AlertSteps extends AbstractEstpApiTest {

    private AlertTableApi alertTableApi;

    public AlertSteps() throws MalformedURLException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void specificSetUp() throws Exception {
        // TODO Auto-generated method stub

    }

    @Given("^I send a request to alert$")
    public void i_send_a_request_to_alert() throws Throwable {
    }

    @Then("^The status code should be OK$")
    public void the_status_code_should_be_OK() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^I should see all the alerts for the current user$")
    public void i_should_see_all_the_alerts_for_the_current_user() throws Throwable {
    }

    @Attachment
    public String response(ApiTestResponse response) {
        return response.getBodyString();
    }

}
