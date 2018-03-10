/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.estp.api.snow.tables.model;

import com.disney.cast.platform.common.api.snow.tables.model.BaseRecord;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author luis.martinez
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EligibilityTableRecord extends BaseRecord {
    @JsonProperty("u_name")
    private String uName;
    @JsonProperty("u_active")
    private String uActive;
    @JsonProperty("u_import_key")
    private String uImportKey;

    @JsonProperty("u_name")
    public String getUName() {
        return uName;
    }

    @JsonProperty("u_name")
    public void setUName(String uName) {
        this.uName = uName;
    }

    @JsonProperty("u_active")
    public String getUActive() {
        return uActive;
    }

    @JsonProperty("u_active")
    public void setUActive(String uActive) {
        this.uActive = uActive;
    }

    @JsonProperty("u_import_key")
    public String getUImportKey() {
        return uImportKey;
    }

    @JsonProperty("u_import_key")
    public void setUImportKey(String uImportKey) {
        this.uImportKey = uImportKey;
    }
}
