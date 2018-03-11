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
import com.fasterxml.jackson.core.type.TypeReference;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * @author roberto
 */
public class AlertSteps extends AbstractEstpApiTest {

    private ApiTestResponse getAlertResponse;
    private Iterator<AlertTableRecord> alertsIterator;

    public AlertSteps() throws MalformedURLException {
        super();
    }

    @Before
    public void beforeScenario() throws Exception {
        System.out.println("----------------Before scenario----------------");
    }

    @Given("^System is unavailable$")
    public void system_is_unavailable() throws Throwable {
        DataManager.getFeatureDataManager().setUnavailable(true);
    }

    @Given("^I send a request to alert$")
    public void i_send_a_request_to_alert() throws Throwable {
        getAlertResponse = getAlert(clients().get(PLANNER.toString()));
    }

    @Then("^The status code should be \"([^\"]*)\"$")
    public void the_status_code_should_be(String expected) throws Throwable {
        Assert.assertEquals(Integer.parseInt(expected), getAlertResponse.getStatus());
    }

    @And("^I should see all the alerts for the current user$")
    public void i_should_see_all_the_alerts_for_the_current_user() throws Throwable {
        List<Alert> returnedAlerts = getAlertResponse
                .getBodyObject(new TypeReference<Result<List<Alert>>>() {
                })
                .getResult();
        attachJson(getAlertResponse.getBodyString());
    }

    @Then("^I should see an error message$")
    public void i_should_see_an_error_message() throws Throwable {
        String UNAVAILABLE_BODY = "error.system.service.unavailable.body";
        String UNAVAILABLE_TITLE = "error.system.service.unavailable.title";
        attachJson(getAlertResponse.getBodyString());
        Message message = getAlertResponse
                .getBodyObject(new TypeReference<Result<Message>>() {
                })
                .getResult();
        assertEquals(UNAVAILABLE_BODY, message.getMessageKey());
        assertEquals(UNAVAILABLE_TITLE, message.getTitleKey());
    }

    @Attachment(value = "JSON", type = "application/json")
    public String attachJson(String json) {
        return json;
    }

    @After
    public void afterScenario() throws Exception {
        DataManager.getFeatureDataManager().setUnavailable(false);
        System.out.println("----------------After scenario----------------");
    }

}
