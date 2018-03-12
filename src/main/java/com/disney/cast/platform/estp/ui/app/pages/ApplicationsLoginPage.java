package com.disney.cast.platform.estp.ui.app.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disney.automation.webframework.pageobject.PageObject;
import com.disney.automation.webframework.webdriver.Browser;
import com.disney.automation.webframework.webdriver.Drivers;

/**
 * @author roberto
 */
public class ApplicationsLoginPage {

    public static final String USERNAME = "jose.x.oropeza.-nd";
    public static final String ACCESS_KEY = "7914dc3b-dbc8-45ec-94d7-353b4f71efef";

    private WebDriver driver;

    @FindBy(id = "user_name")
    private WebElement userNameTextBox;

    @FindBy(id = "user_password")
    private WebElement userPasswordTextBox;

    @FindBy(id = "sysverb_login")
    private WebElement loginButton;

    public ApplicationsLoginPage() throws MalformedURLException {
        URL sauceUrl = new URL("https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub");
        Drivers.INSTANCE.create(Browser.CHROME, sauceUrl);
        this.driver = Drivers.INSTANCE.get();
        this.driver.get(getOwnUrl());
        printSessionId();
        PageFactory.initElements(driver, this);
    }

    private void printSessionId() {
        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
                (((RemoteWebDriver) driver).getSessionId()).toString(), System.getenv("JOB_NAME"));
        System.out.println(message);
    }

    public <T extends PageObject> T logIn(String userName, String userPassword, Class<T> nextPageClass)
            throws Exception {
        /*
         * this.goToOwnUrl(); type(userNameTextBox, userName); type(userPasswordTextBox,
         * userPassword); click(loginButton);
         * waitFor(urlContains("view_content.do?sysparm_sys_id=")); T nextPage =
         * nextPageClass.newInstance(); nextPage.goToOwnUrl(); return nextPage;
         */
        return null;
    }

    public void goToOwnUrl() {
        driver.get(getOwnUrl());
    }

    protected String getOwnUrl() {
        return "https://wdprautomation.service-now.com/wdpr-cast/login.do";
    }
}
