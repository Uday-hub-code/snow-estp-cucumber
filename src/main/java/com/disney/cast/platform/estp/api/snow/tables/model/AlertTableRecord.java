/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.estp.api.snow.tables.model;

import com.disney.cast.platform.common.api.snow.tables.model.BaseRecord;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author luis.martinez
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertTableRecord extends BaseRecord {
    @JsonProperty("u_body")
    private String uBody;
    @JsonProperty("u_role")
    private String uRole;
    @JsonProperty("u_active")
    private String uActive;
    @JsonProperty("u_type")
    private String uType;

    @JsonProperty("u_body")
    public String getUBody() {
        return uBody;
    }

    @JsonProperty("u_body")
    public void setUBody(String uBody) {
        this.uBody = uBody;
    }

    @JsonProperty("u_role")
    public String getURole() {
        return uRole;
    }

    @JsonProperty("u_role")
    public void setURole(String uRole) {
        this.uRole = uRole;
    }

    @JsonProperty("u_active")
    public String getUActive() {
        return uActive;
    }

    @JsonProperty("u_active")
    public void setUActive(String uActive) {
        this.uActive = uActive;
    }

    @JsonProperty("u_type")
    public String getUType() {
        return uType;
    }

    @JsonProperty("u_type")
    public void setUType(String uType) {
        this.uType = uType;
    }
}
