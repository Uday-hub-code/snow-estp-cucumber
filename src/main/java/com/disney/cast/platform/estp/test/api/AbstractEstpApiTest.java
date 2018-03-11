package com.disney.cast.platform.estp.test.api;

import java.net.MalformedURLException;

import com.disney.automation.servicetesting.core.AbstractApiTest;

/**
 * @author walter.finkbeiner
 */
public abstract class AbstractEstpApiTest extends AbstractApiTest {

    public AbstractEstpApiTest() throws MalformedURLException {
        super();
    }

    @Override
    protected Object[] setAuthLevels() {
        return ApiAuthLevel.values();
    }
}
