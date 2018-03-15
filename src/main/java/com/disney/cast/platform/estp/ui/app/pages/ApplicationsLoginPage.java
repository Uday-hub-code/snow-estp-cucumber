package com.disney.cast.platform.estp.ui.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disney.automation.webframework.pageobject.PageObject;
import com.disney.automation.webframework.webdriver.Browser;
import com.disney.automation.webframework.webdriver.Drivers;

/**
 * @author roberto
 */
public class ApplicationsLoginPage {

    private WebDriver driver;

    @FindBy(id = "inputEmail")
    private WebElement userNameTextBox;

    @FindBy(id = "inputPassword")
    private WebElement userPasswordTextBox;

    @FindBy(id = "submitButton")
    private WebElement loginButton;

    public ApplicationsLoginPage() {
        Drivers.INSTANCE.create(Browser.CHROME);
        this.driver = Drivers.INSTANCE.get();
        this.driver.get(getOwnUrl());
        PageFactory.initElements(driver, this);
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
        return "https://hub.disney.com";
        // return "https://wdprautomation.service-now.com/wdpr-cast/login.do";
    }
}
