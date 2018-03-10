/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.estp.api.snow.tables.model;

import com.disney.cast.platform.common.api.snow.tables.model.BaseRecord;
import com.disney.cast.platform.common.api.snow.tables.model.LinkValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author luis.martinez
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UIUserTableRecord extends BaseRecord {
    @JsonProperty("u_leader")
    private LinkValue uLeader;
    @JsonProperty("u_active")
    private String uActive;
    @JsonProperty("u_user")
    private LinkValue uUser;
    @JsonProperty("u_payroll")
    private LinkValue uPayroll;

    @JsonProperty("u_role")
    private String uRole;

    @JsonProperty("u_leader")
    public LinkValue getULeader() {
        return uLeader;
    }

    @JsonProperty("u_leader")
    public void setULeader(LinkValue uLeader) {
        this.uLeader = uLeader;
    }

    @JsonProperty("u_active")
    public String getUActive() {
        return uActive;
    }

    @JsonProperty("u_active")
    public void setUActive(String uActive) {
        this.uActive = uActive;
    }

    @JsonProperty("u_user")
    public LinkValue getUUser() {
        return uUser;
    }

    @JsonProperty("u_user")
    public void setUUser(LinkValue uUser) {
        this.uUser = uUser;
    }

    @JsonProperty("u_role")
    public String getURole() {
        return uRole;
    }

    @JsonProperty("u_role")
    public void setURole(String uRole) {
        this.uRole = uRole;
    }

    @JsonProperty("u_payroll")
    public LinkValue getUPayroll() {
        return uPayroll;
    }

    @JsonProperty("u_payroll")
    public void setUPayroll(LinkValue uPayroll) {
        this.uPayroll = uPayroll;
    }
}
