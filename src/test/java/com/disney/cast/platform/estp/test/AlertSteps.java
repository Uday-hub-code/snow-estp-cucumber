package com.disney.cast.platform.estp.test;

import static com.disney.cast.platform.estp.api.app.AlertApi.getAlert;
import static com.disney.cast.platform.estp.test.api.ApiAuthLevel.PLANNER;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;

import com.disney.automation.servicetesting.core.ApiTestResponse;
import com.disney.cast.platform.common.api.app.model.Message;
import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.estp.api.app.model.Alert;
import com.disney.cast.platform.estp.api.snow.tables.model.AlertTableRecord;
import com.disney.cast.platform.estp.data.DataManager;
import com.disney.cast.platform.estp.test.api.AbstractEstpApiTest;
import com.disney.cast.platform.estp.test.api.ApiAuthLevel;
import com.fasterxml.jackson.core.type.TypeReference;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author roberto
 */
public class AlertSteps extends AbstractEstpApiTest {

    private ApiTestResponse response;
    private Iterator<AlertTableRecord> alertsIterator;

    public AlertSteps() throws MalformedURLException {
        super();
    }

    @Given("^System is available$")
    public void system_is_available() throws Throwable {
        DataManager.getFeatureDataManager().setUnavailable(false);
    }

    @Given("^System is unavailable$")
    public void system_is_unavailable() throws Throwable {
        DataManager.getFeatureDataManager().setUnavailable(true);
    }

    @Given("^I create an alert$")
    public void i_create_an_alert() throws Throwable {
        DataManager.getAlertDataManager().deleteAll();
        alertsIterator = DataManager.getAlertDataManager().addActive(1).iterator();
    }

    @When("^I send a request to alert with wrong user$")
    public void i_send_a_request_to_alert_with_wrong_user() throws Throwable {
        response = getAlert(clients().get(ApiAuthLevel.WRONG_AUTH.toString()));
    }

    @When("^I send a request to alert$")
    public void i_send_a_request_to_alert() throws Throwable {
        response = getAlert(clients().get(PLANNER.toString()));
        attachJson(response.getBodyString());
    }

    @Then("^The status code should be \"([^\"]*)\"$")
    public void the_status_code_should_be(String expected) throws Throwable {
        Assert.assertEquals(Integer.parseInt(expected), response.getStatus());
    }

    @And("^I should see all the alerts for the current user$")
    public void i_should_see_all_the_alerts_for_the_current_user() throws Throwable {
        List<Alert> returnedAlerts = response
                .getBodyObject(new TypeReference<Result<List<Alert>>>() {
                })
                .getResult();
    }

    @Then("^I should see an error message$")
    public void i_should_see_an_error_message() throws Throwable {
        String UNAVAILABLE_BODY = "error.system.service.unavailable.body";
        String UNAVAILABLE_TITLE = "error.system.service.unavailable.title";
        Message message = response
                .getBodyObject(new TypeReference<Result<Message>>() {
                })
                .getResult();
        assertEquals(UNAVAILABLE_BODY, message.getMessageKey());
        assertEquals(UNAVAILABLE_TITLE, message.getTitleKey());
    }

    @Then("^Delete alerts created$")
    public void delete_alerts_created() throws Throwable {
        if (alertsIterator != null) {
            while (alertsIterator.hasNext()) {
                AlertTableRecord alert = alertsIterator.next();
                DataManager.getAlertDataManager().delete(alert);
            }

        }
    }

}
