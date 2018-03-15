package com.disney.cast.platform.estp.test.snow;

import cucumber.api.java.en.But;
import cucumber.api.java.en.Then;

public class SnowSteps {

    @Then("^I go to snow$")
    public void i_go_to_snow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @But("^I should see an error here$")
    public void i_should_see_an_error_here() {
        throw new NullPointerException("Fix me!");
    }

}
