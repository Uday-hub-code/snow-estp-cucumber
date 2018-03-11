package com.disney.cast.platform.estp.test.api;

import java.net.MalformedURLException;

import org.junit.Before;

import com.disney.automation.servicetesting.core.AbstractApiTest;

/**
 * @author walter.finkbeiner
 */
public abstract class AbstractEstpApiTest extends AbstractApiTest {

    public AbstractEstpApiTest() throws MalformedURLException {
        super();
    }

    @Before
    public void generalSetup() throws Exception {
        specificSetUp();
    }

    protected abstract void specificSetUp() throws Exception;

    @Override
    protected Object[] setAuthLevels() {
        return ApiAuthLevel.values();
    }
}
