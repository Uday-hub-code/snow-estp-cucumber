package com.disney.cast.platform.estp.test;

import com.disney.cast.platform.estp.data.DataManager;

import cucumber.api.java.Before;

/**
 * @author roberto
 */
public class CommonSteps {

    @Before
    public void beforeScenario() throws Exception {
        DataManager.getFeatureDataManager().setUnavailable(false);
    }
}
