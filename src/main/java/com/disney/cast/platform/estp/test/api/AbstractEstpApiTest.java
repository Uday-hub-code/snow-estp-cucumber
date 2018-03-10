package com.disney.cast.platform.estp.test.api;

import static com.disney.cast.platform.estp.data.DataManager.ALERT_DATA_MANAGER;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Rule;

import com.disney.automation.servicetesting.core.AbstractApiTest;
import com.disney.cast.platform.estp.data.DataManager;

/**
 * @author walter.finkbeiner
 */
public abstract class AbstractEstpApiTest extends AbstractApiTest {

    public AbstractEstpApiTest() throws MalformedURLException {
        super();
    }

    @Rule
    public DataManager dataManager = new DataManager();

    @Before
    public void generalSetup() throws Exception {
        ALERT_DATA_MANAGER.deleteAll();
        specificSetUp();
    }

    protected abstract void specificSetUp() throws Exception;

    @Override
    protected Object[] setAuthLevels() {
        return ApiAuthLevel.values();
    }
}
