package com.disney.cast.platform.estp.api.alert.get;

import static com.disney.automation.servicetesting.config.Framework.CONFIGURATION;
import static com.disney.cast.platform.estp.api.app.AlertApi.getAlert;
import static com.disney.cast.platform.estp.data.DataManager.ALERT_DATA_MANAGER;
import static com.disney.cast.platform.estp.test.api.ApiAuthLevel.LEADER;
import static com.disney.cast.platform.estp.test.api.ApiAuthLevel.PLANNER;
import static com.disney.cast.platform.estp.test.api.ApiAuthLevel.SNOWADMIN;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import com.disney.automation.servicetesting.core.ApiTestResponse;
import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.common.api.snow.tables.model.SysUserTableRecord;
import com.disney.cast.platform.estp.api.app.model.Alert;
import com.disney.cast.platform.estp.api.snow.tables.AlertTableApi;
import com.disney.cast.platform.estp.api.snow.tables.model.AlertTableRecord;
import com.disney.cast.platform.estp.api.snow.tables.model.PayrollTableRecord;
import com.disney.cast.platform.estp.data.DataManager;
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
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;

public class GetAlertTest extends AbstractEstpApiTest {

    private static final int ACTIVE_ALERT_TO_ADD = 1;
    private static final int INACTIVE_ALERT_TO_ADD = 1;

    public GetAlertTest() throws MalformedURLException {
    }

    @Override
    public void specificSetUp() throws Exception {
        ALERT_DATA_MANAGER.addActive(ACTIVE_ALERT_TO_ADD);
        ALERT_DATA_MANAGER.addInactive(INACTIVE_ALERT_TO_ADD);
        SysUserTableRecord planner = DataManager.USER_DATA_MANAGER
                .getUserByName(CONFIGURATION.account(PLANNER.toString()).getUserName());
        PayrollTableRecord payroll = DataManager.PAYROLL_DATA_MANAGER.addPayroll(1).iterator().next();
        DataManager.UI_USER_DATA_MANAGER
                .addActive(planner,
                        DataManager.USER_DATA_MANAGER
                                .getUserByName(CONFIGURATION.account(LEADER.toString()).getUserName()),
                        payroll);
    }

    @Step
    private void validateStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, 200);
    }

    @Step
    private void validateSizeOfAlerts(int alertsFromTableApi, int alertsFromEndpoint) {
        Assert.assertEquals(alertsFromTableApi, alertsFromEndpoint);
    }

    @Description("Happy path for /alert endpoint.")
    @Epic("Smoke Tests")
    @Issue("PPE-10717")
    @Owner("Jose")
    @Feature("Alert")
    @Tag("API")
    @DisplayName("Alert SUCCESS")
    @Tag("API")
    @Tag("GET")
    @Link(name = "Confluence", type = "mylink", url = "https://confluence.disney.com/pages/viewpage.action?pageId=309822521")
    @TmsLink("https://hpalm.com")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void getAlertTest() throws Exception {
        AlertTableApi alertTableApi = new AlertTableApi();
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

        validateStatusCode(getAlertResponse.getStatus());
        validateSizeOfAlerts(activeAlertsRecordsFromTableApi.size(), returnedAlerts.size());
        List<AlertVO> apiTableAlerts = activeAlertsRecordsFromTableApi
                .stream()
                .map(alert -> new AlertVO(alert.getUType(), alert.getUBody()))
                .collect(Collectors.toList());

        List<AlertVO> apiAlerts = returnedAlerts
                .stream()
                .map(alert -> new AlertVO(alert.getType(), alert.getBody()))
                .collect(Collectors.toList());

        assertTrue(String.format("The Alerts don't match. \nExpected: %s\nActual: %s", apiTableAlerts, apiAlerts),
                apiTableAlerts.containsAll(apiAlerts) && apiAlerts.containsAll(apiTableAlerts));
    }

    public static class AlertVO {
        final String type;
        final String body;

        public AlertVO(String type, String body) {
            this.type = type;
            this.body = body;
        }

        @Override
        public boolean equals(Object o) {
            AlertVO a = (AlertVO) o;
            return a.type.equals(type) && a.body.equals(body);
        }

        @Override
        public String toString() {
            return String.format("Body: '%s'\tType: %s", body, type);
        }
    }
}
