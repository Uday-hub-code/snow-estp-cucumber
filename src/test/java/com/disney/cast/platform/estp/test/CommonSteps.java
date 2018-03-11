package com.disney.cast.platform.estp.test;

import com.disney.cast.platform.estp.data.DataManager;

import cucumber.api.java.Before;

/**
 * @author roberto
 */
public class CommonSteps {

    @Before(order = 0)
    public void beforeScenario() throws Exception {
        DataManager.getFeatureDataManager().setUnavailable(false);
    }
}
