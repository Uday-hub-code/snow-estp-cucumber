package com.disney.cast.platform.estp.test.ui;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Rule;

import com.disney.automation.webframework.logging.CustomTestWatcher;
import com.disney.automation.webframework.tests.JUnit4WebDriverTest;
import com.disney.cast.platform.estp.data.DataManager;

public abstract class AbstractEstpUiTest extends JUnit4WebDriverTest {

    public AbstractEstpUiTest() throws MalformedURLException {
        super();
    }

    @Rule
    public DataManager dataManager = new DataManager();

    @Rule
    public CustomTestWatcher customTestWatcher = new CustomTestWatcher();

    @Before
    public void generalSetup() throws Exception {
        specificSetUp();
    }

    @Override
    protected Object[] setAuthLevels() {
        return UiAuthLevel.values();
    }

    protected abstract void specificSetUp() throws Exception;
}
