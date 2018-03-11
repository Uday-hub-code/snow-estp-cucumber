package com.disney.cast.platform.estp.test.snow;

import cucumber.api.java.en.But;

public class SnowSteps {

    @But("^I should see an error here$")
    public void i_should_see_an_error_here() {
        throw new NullPointerException("Fix me!");
    }

}
