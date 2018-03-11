package com.disney.cast.platform.estp.api.app;

import static com.disney.automation.servicetesting.core.RestMethod.GET;

import com.disney.automation.servicetesting.core.ApiTestClient;
import com.disney.automation.servicetesting.core.ApiTestRequest;
import com.disney.automation.servicetesting.core.ApiTestResponse;

public class AlertApi {

    private ApiTestClient apiTestClient;
    private ApiTestRequest request;
    private static final String PATH = "/api/x_wdtpa_wdpr_vacat/v1/vacation_planner/alert";

    public AlertApi(final ApiTestClient apiTestClient) {
        this.apiTestClient = apiTestClient;
    }

    public ApiTestRequest getRequest() {
        return request;
    }

    public ApiTestResponse get() throws Exception {
        request = new ApiTestRequest.Builder()
                .setPath(PATH)
                .setMethod(GET)
                .build();
        return apiTestClient.execute(request);
    }
}
