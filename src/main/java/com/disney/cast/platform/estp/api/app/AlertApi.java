package com.disney.cast.platform.estp.api.app;

import static com.disney.automation.servicetesting.core.RestMethod.GET;

import com.disney.automation.servicetesting.core.ApiTestClient;
import com.disney.automation.servicetesting.core.ApiTestRequest;
import com.disney.automation.servicetesting.core.ApiTestResponse;

public class AlertApi {

    private ApiTestRequest request;
    private static final String PATH = "/api/x_wdtpa_wdpr_vacat/v1/vacation_planner/alert";

    public ApiTestRequest getRequest() {
        return request;
    }

    public ApiTestResponse get(final ApiTestClient client) throws Exception {
        request = new ApiTestRequest.Builder()
                .setPath(PATH)
                .setMethod(GET)
                .build();
        return client.execute(request);
    }
}
