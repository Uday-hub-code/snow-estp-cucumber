package com.disney.cast.platform.estp.test;

import static com.disney.cast.platform.estp.api.app.AlertApi.getAlert;
import static com.disney.cast.platform.estp.test.api.ApiAuthLevel.PLANNER;
import static com.disney.cast.platform.estp.test.api.ApiAuthLevel.SNOWADMIN;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;

import com.disney.automation.servicetesting.core.ApiTestResponse;
import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.estp.api.app.model.Alert;
import com.disney.cast.platform.estp.api.snow.tables.AlertTableApi;
import com.disney.cast.platform.estp.api.snow.tables.model.AlertTableRecord;
import com.disney.cast.platform.estp.test.api.AbstractEstpApiTest;
import com.fasterxml.jackson.core.type.TypeReference;

import cucumber.api.PendingException;
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
        alertTableApi = new AlertTableApi();
    }

    @Then("^The status code should be OK$")
    public void the_status_code_should_be_OK() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see all the alerts for the current user$")
    public void i_should_see_all_the_alerts_for_the_current_user() throws Throwable {
        List<AlertTableRecord> activeAlertsRecordsFromTableApi = alertTableApi
                .get(clients().get(SNOWADMIN.toString()),
                        "?sysparm_query=u_active%3Dtrue")
                .getBodyObject(new TypeReference<Result<List<AlertTableRecord>>>() {
                })
                .getResult();

        ApiTestResponse getAlertResponse = getAlert(clients().get(PLANNER.toString()));
        List<Alert> returnedAlerts = getAlertResponse
                .getBodyObject(new TypeReference<Result<List<Alert>>>() {
                })
                .getResult();
        Assert.assertEquals(getAlertResponse.getStatus(), 200);
        response(getAlertResponse);
    }

    @Attachment
    public String response(ApiTestResponse response) {
        return response.getBodyString();
    }

}
