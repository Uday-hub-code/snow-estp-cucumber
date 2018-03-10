package com.disney.cast.platform.estp.ui.app.home;

import static com.disney.cast.platform.estp.test.ui.UiAuthLevel.SNOWADMIN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Test;

import com.disney.automation.webframework.config.User;
import com.disney.cast.platform.common.ui.pages.ApplicationsLoginPage;
import com.disney.cast.platform.estp.test.ui.AbstractEstpUiTest;
import com.disney.cast.platform.estp.ui.app.pages.home.HomePage;

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

public class LoginSuccessfulTest extends AbstractEstpUiTest {

    private final User planner = users().get(SNOWADMIN.toString());

    public LoginSuccessfulTest() throws MalformedURLException {
    }

    @Override
    public void specificSetUp() throws Exception {
    }

    @Description("Login successful to ESTP.")
    @Epic("Smoke Tests")
    @Issue("PPE-10717")
    @Owner("Jose")
    @Feature("Login")
    @DisplayName("Access to the application")
    @Tag("API")
    @Tag("UI")
    @Link(name = "Confluence", type = "mylink", url = "https://confluence.disney.com/pages/viewpage.action?pageId=309822521")
    @TmsLink("https://hpalm.com")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void loginSuccessfulTest() throws Exception {
        ApplicationsLoginPage loginPage = new ApplicationsLoginPage();
        HomePage homePage = loginPage.logIn(planner.getUserName(), planner.getPass(), HomePage.class);

        assertTrue("Planner should have been able to log in. Home page is not displayed", homePage.isVisible());
        assertEquals("This Month's Performance", homePage.getThisMonthsPerformance());
        assertEquals("View Full Performance Summary", homePage.getViewFullPerformance());
        assertEquals("View Reward History", homePage.getRewardHistory());
    }

}
