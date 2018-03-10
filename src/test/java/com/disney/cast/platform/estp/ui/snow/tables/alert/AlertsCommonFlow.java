package com.disney.cast.platform.estp.ui.snow.tables.alert;

import static com.disney.cast.platform.estp.test.ui.UiAuthLevel.SNOWADMIN;

import java.util.Map;

import com.disney.automation.webframework.config.User;
import com.disney.cast.platform.common.ui.pages.ServiceNowLoginPage;
import com.disney.cast.platform.common.ui.snow.pages.commoncomponents.AccordionComponent;
import com.disney.cast.platform.common.ui.snow.pages.home.SnowHomePage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;

/**
 * https://jira.disney.com/browse/PPE-2784
 *
 * @author erick.ricardez
 */
public class AlertsCommonFlow {

    static public SnowRecordsListPage navigationToAlertContent(Map<Object, User> users)
            throws Exception {
        ServiceNowLoginPage loginPage = new ServiceNowLoginPage();
        User user = users.get(SNOWADMIN.toString());
        SnowHomePage snowHomePage = loginPage.logIn(user.getUserName(), user.getPass(), SnowHomePage.class);
        AccordionComponent sideBarDecoratingSupportAccordion = snowHomePage
                .getSideBar()
                .filter("WDPR Vacation Planner Rewards")
                .getApplicationsAccordion("WDPR Vacation Planner Rewards");
        return sideBarDecoratingSupportAccordion.clickOnListElement("Alerts",
                SnowRecordsListPage.class);
    }
}
