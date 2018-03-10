package com.disney.cast.platform.estp.api.app;

import static com.disney.automation.servicetesting.core.RestMethod.GET;

import com.disney.automation.servicetesting.core.ApiTestClient;
import com.disney.automation.servicetesting.core.ApiTestRequest;
import com.disney.automation.servicetesting.core.ApiTestResponse;

/**
 * @author erick.ricardez
 */
public class AlertApi {

    private static final String path = "/api/x_wdtpa_wdpr_vacat/v1/vacation_planner/alert";

    public static ApiTestResponse getAlert(final ApiTestClient client) throws Exception {
        ApiTestRequest request = new ApiTestRequest.Builder()
                .setPath(path)
                .setMethod(GET)
                .build();
        return client.execute(request);
    }
}
