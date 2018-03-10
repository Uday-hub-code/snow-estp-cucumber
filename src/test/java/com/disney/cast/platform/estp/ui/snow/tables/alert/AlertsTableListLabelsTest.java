/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.estp.ui.snow.tables.alert;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.Set;

import org.junit.Test;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.estp.test.ui.AbstractEstpUiTest;

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
 * https://jira.disney.com/browse/PPE-2784 Verify Alerts table page labels in SNOW UI
 *
 * @author erick.ricardez
 */
public class AlertsTableListLabelsTest extends AbstractEstpUiTest {

    private static final String[] expectedTableLabels = {
            "active",
            "body",
            "type" };

    public AlertsTableListLabelsTest() throws MalformedURLException {
    }

    @Override
    public void specificSetUp() throws Exception {
    }

    @Description("Validate labels in Snow.")
    @Epic("Regression Tests")
    @Issue("PPE-10717")
    @Owner("Jose")
    @Feature("Snow")
    @DisplayName("Access to the application")
    @Tag("SNOW")
    @Tag("UI")
    @Link(name = "Confluence", type = "mylink", url = "https://confluence.disney.com/pages/viewpage.action?pageId=309822521")
    @TmsLink("https://hpalm.com")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    public void entitlementsTableListLabelsTest() throws Exception {
        SnowRecordsListPage entitlementsRecordsListPage = AlertsCommonFlow
                .navigationToAlertContent(users());
        entitlementsRecordsListPage.goToContentIframe();
        Set<String> entitlementsListHeadersText = entitlementsRecordsListPage
                .getListHeader()
                .getListHeadersText();
        assertTrue("The amount of labels in the records table header is not the expected one",
                entitlementsListHeadersText.size() >= expectedTableLabels.length);
        for (String expectedLabel : expectedTableLabels) {
            assertTrue(expectedLabel + " was supposed to be present in the records table headers",
                    entitlementsListHeadersText.contains(expectedLabel));
        }
    }

}
