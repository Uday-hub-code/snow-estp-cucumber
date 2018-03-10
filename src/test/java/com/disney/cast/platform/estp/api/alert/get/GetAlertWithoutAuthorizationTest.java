package com.disney.cast.platform.estp.api.alert.get;

import static com.disney.cast.platform.estp.api.app.AlertApi.getAlert;
import static com.disney.cast.platform.estp.test.api.ApiAuthLevel.NO_AUTH;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Test;

import com.disney.automation.servicetesting.core.ApiTestResponse;
import com.disney.cast.platform.common.api.model.Error;
import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.estp.test.api.AbstractEstpApiTest;
import com.fasterxml.jackson.core.type.TypeReference;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;

/**
 * https://jira.disney.com/browse/PPE-2340
 *
 * @author erick.ricardez
 */
public class GetAlertWithoutAuthorizationTest extends AbstractEstpApiTest {

    public GetAlertWithoutAuthorizationTest() throws MalformedURLException {
        super();
    }

    @Override
    public void specificSetUp() throws Exception {
    }

    @Description("No authorization test for /alert endpoint.")
    @Epic("Regression Tests")
    @Issue("PPE-10717")
    @Owner("Jose")
    @Feature("Alert")
    @DisplayName("Access to /alert endpoint without authorization")
    @Tag("API")
    @Tag("GET")
    @Link(name = "Confluence", type = "mylink", url = "https://confluence.disney.com/pages/viewpage.action?pageId=309822521")
    @TmsLink("https://hpalm.com")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void getAlertWithoutAuthorizationTest() throws Exception {
        ApiTestResponse alertResponse = getAlert(clients().get(NO_AUTH.toString()));
        int statusCode = alertResponse.getStatus();
        Error error = alertResponse
                .getBodyObject(new TypeReference<Result<Error>>() {
                })
                .getResult();
        assertEquals(
                String.format(
                        "When making a request to /vacation_planner/alert without credentials, the HTTP status code of the response should be 401 instead of %s",
                        alertResponse.getStatus()),
                200, statusCode);
        assertEquals(
                String.format(
                        "When making a request to /vacation_planner/alert without credentials, the error response body should show %s as message key",
                        Error.Messages.UNAUTHORIZED_MESSAGE_BODY),
                Error.Messages.UNAUTHORIZED_MESSAGE_BODY, error.getMessageKey());
        assertEquals(
                String.format(
                        "When making a request to /vacation_planner/alert without credentials, the error response body should show %s as title key",
                        Error.Messages.UNAUTHORIZED_TITLE_KEY),
                Error.Messages.UNAUTHORIZED_TITLE_KEY, error.getTitleKey());
    }
}
