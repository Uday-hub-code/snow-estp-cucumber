package com.disney.cast.platform.estp.api.snow.tables.model;

import com.disney.cast.platform.common.api.snow.tables.model.BaseRecord;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author walter.finkbeiner
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeatureTableRecord extends BaseRecord {

    @JsonProperty("u_value")
    private boolean uValue;
    @JsonProperty("u_key")
    private String uKey;
    @JsonProperty("u_description")
    private String uDescription;

    @JsonProperty("u_value")
    public boolean getUValue() {
        return uValue;
    }

    @JsonProperty("u_value")
    public void setUValue(boolean uValue) {
        this.uValue = uValue;
    }

    @JsonProperty("u_key")
    public String getUKey() {
        return uKey;
    }

    @JsonProperty("u_key")
    public void setUKey(String uKey) {
        this.uKey = uKey;
    }

    @JsonProperty("u_description")
    public String getuDescription() {
        return uDescription;
    }

    @JsonProperty("u_description")
    public void setuDescription(String uDescription) {
        this.uDescription = uDescription;
    }
}
