package com.disney.cast.platform.estp.test.ui;

import java.net.MalformedURLException;

import com.disney.automation.webframework.tests.JUnit4WebDriverTest;

public abstract class AbstractEstpUiTest extends JUnit4WebDriverTest {

    public AbstractEstpUiTest() throws MalformedURLException {
        super();
    }

    @Override
    protected Object[] setAuthLevels() {
        return UiAuthLevel.values();
    }

}
