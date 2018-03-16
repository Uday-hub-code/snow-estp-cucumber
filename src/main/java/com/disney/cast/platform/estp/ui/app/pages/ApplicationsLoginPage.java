package com.disney.cast.platform.estp.ui.app.pages;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disney.automation.webframework.pageobject.PageObject;
import com.disney.automation.webframework.visual.Ocular;
import com.disney.automation.webframework.visual.comparator.OcularResult;
import com.disney.automation.webframework.visual.snapshot.Snap;
import com.disney.automation.webframework.webdriver.Browser;
import com.disney.automation.webframework.webdriver.Drivers;

/**
 * @author roberto
 */
@Snap("Login#{OPT}.png")
public class ApplicationsLoginPage {

    private WebDriver driver;

    @FindBy(id = "inputEmail")
    private WebElement userNameTextBox;

    @FindBy(id = "inputPassword")
    private WebElement userPasswordTextBox;

    @FindBy(id = "submitButton")
    private WebElement loginButton;

    @FindBy(className = "video_playlist_inline")
    private WebElement videoSection;

    @FindBy(className = "goc-logo-image")
    private WebElement logoButton;

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
        return "http://www.disney.com";
        // return "https://wdprautomation.service-now.com/wdpr-cast/login.do";
    }

    public OcularResult compare() {
        // a random pause to get different images
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Ocular
                .snapshot()
                .from(this)
                .replaceAttribute("OPT", "")
                .sample()
                .using(driver)
                .compare();
    }

    public OcularResult compareExcludingVideo() {
        // a random pause to get different images
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Ocular
                .snapshot()
                .from(this)
                .replaceAttribute("OPT", "_noVideo")
                .sample()
                .using(driver)
                .excluding(videoSection)
                .compare();
    }

    public OcularResult compareLogoButton() {
        // a random pause to get different images
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Ocular
                .snapshot()
                .from(this)
                .replaceAttribute("OPT", "_logoButton")
                .sample()
                .element(logoButton)
                .using(driver)
                .compare();
    }
}
