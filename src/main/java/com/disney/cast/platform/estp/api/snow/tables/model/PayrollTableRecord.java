/**
 *
 */
package com.disney.cast.platform.estp.api.snow.tables.model;

import com.disney.cast.platform.common.api.snow.tables.model.BaseRecord;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author luis.martinez
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayrollTableRecord extends BaseRecord {
    @JsonProperty("u_cost_center_description")
    private String uCostCenterDescription;
    @JsonProperty("u_reason_for_change")
    private String uReasonForChange;
    @JsonProperty("u_number")
    private String uNumber;
    @JsonProperty("u_company_code")
    private String uCompanyCode;
    @JsonProperty("u_date")
    private String uDate;
    @JsonProperty("u_infotype")
    private String uInfotype;
    @JsonProperty("u_int_order")
    private String uIntOrder;
    @JsonProperty("u_wbs_element")
    private String uWbsElement;
    @JsonProperty("u_text_field")
    private String uTextField;
    @JsonProperty("u_dest_geo")
    private String uDestGeo;
    @JsonProperty("u_network")
    private String uNetwork;
    @JsonProperty("u_mpm_issue")
    private String uMpmIssue;
    @JsonProperty("u_unit")
    private String uUnit;
    @JsonProperty("u_period")
    private String uPeriod;
    @JsonProperty("u_activity")
    private String uActivity;
    @JsonProperty("u_business_area")
    private String uBusinessArea;
    @JsonProperty("u_cost_center")
    private String uCostCenter;

    @JsonProperty("u_cost_center_description")
    public String getUCostCenterDescription() {
        return uCostCenterDescription;
    }

    @JsonProperty("u_cost_center_description")
    public void setUCostCenterDescription(String uCostCenterDescription) {
        this.uCostCenterDescription = uCostCenterDescription;
    }

    @JsonProperty("u_reason_for_change")
    public String getUReasonForChange() {
        return uReasonForChange;
    }

    @JsonProperty("u_reason_for_change")
    public void setUReasonForChange(String uReasonForChange) {
        this.uReasonForChange = uReasonForChange;
    }

    @JsonProperty("u_number")
    public String getUNumber() {
        return uNumber;
    }

    @JsonProperty("u_number")
    public void setUNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    @JsonProperty("u_company_code")
    public String getUCompanyCode() {
        return uCompanyCode;
    }

    @JsonProperty("u_company_code")
    public void setUCompanyCode(String uCompanyCode) {
        this.uCompanyCode = uCompanyCode;
    }

    @JsonProperty("u_date")
    public String getUDate() {
        return uDate;
    }

    @JsonProperty("u_date")
    public void setUDate(String uDate) {
        this.uDate = uDate;
    }

    @JsonProperty("u_infotype")
    public String getUInfotype() {
        return uInfotype;
    }

    @JsonProperty("u_infotype")
    public void setUInfotype(String uInfotype) {
        this.uInfotype = uInfotype;
    }

    @JsonProperty("u_int_order")
    public String getUIntOrder() {
        return uIntOrder;
    }

    @JsonProperty("u_int_order")
    public void setUIntOrder(String uIntOrder) {
        this.uIntOrder = uIntOrder;
    }

    @JsonProperty("u_wbs_element")
    public String getUWbsElement() {
        return uWbsElement;
    }

    @JsonProperty("u_wbs_element")
    public void setUWbsElement(String uWbsElement) {
        this.uWbsElement = uWbsElement;
    }

    @JsonProperty("u_text_field")
    public String getUTextField() {
        return uTextField;
    }

    @JsonProperty("u_text_field")
    public void setUTextField(String uTextField) {
        this.uTextField = uTextField;
    }

    @JsonProperty("u_dest_geo")
    public String getUDestGeo() {
        return uDestGeo;
    }

    @JsonProperty("u_dest_geo")
    public void setUDestGeo(String uDestGeo) {
        this.uDestGeo = uDestGeo;
    }

    @JsonProperty("u_network")
    public String getUNetwork() {
        return uNetwork;
    }

    @JsonProperty("u_network")
    public void setUNetwork(String uNetwork) {
        this.uNetwork = uNetwork;
    }

    @JsonProperty("u_mpm_issue")
    public String getUMpmIssue() {
        return uMpmIssue;
    }

    @JsonProperty("u_mpm_issue")
    public void setUMpmIssue(String uMpmIssue) {
        this.uMpmIssue = uMpmIssue;
    }

    @JsonProperty("u_unit")
    public String getUUnit() {
        return uUnit;
    }

    @JsonProperty("u_unit")
    public void setUUnit(String uUnit) {
        this.uUnit = uUnit;
    }

    @JsonProperty("u_period")
    public String getUPeriod() {
        return uPeriod;
    }

    @JsonProperty("u_period")
    public void setUPeriod(String uPeriod) {
        this.uPeriod = uPeriod;
    }

    @JsonProperty("u_activity")
    public String getUActivity() {
        return uActivity;
    }

    @JsonProperty("u_activity")
    public void setUActivity(String uActivity) {
        this.uActivity = uActivity;
    }

    @JsonProperty("u_business_area")
    public String getUBusinessArea() {
        return uBusinessArea;
    }

    @JsonProperty("u_business_area")
    public void setUBusinessArea(String uBusinessArea) {
        this.uBusinessArea = uBusinessArea;
    }

    @JsonProperty("u_cost_center")
    public String getUCostCenter() {
        return uCostCenter;
    }

    @JsonProperty("u_cost_center")
    public void setUCostCenter(String uCostCenter) {
        this.uCostCenter = uCostCenter;
    }
}
