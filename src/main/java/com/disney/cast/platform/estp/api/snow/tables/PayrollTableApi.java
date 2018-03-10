package com.disney.cast.platform.estp.api.snow.tables;

import com.disney.cast.platform.common.api.snow.tables.AbstractGenericTableApi;
import com.disney.cast.platform.estp.api.snow.tables.model.PayrollTableRecord;

/**
 * @author walter.finkbeiner
 */
public class PayrollTableApi extends AbstractGenericTableApi<PayrollTableRecord> {

    @Override
    protected String setPath() {
        return "/api/now/table/x_wdtpa_wdpr_vacat_payroll";
    }

}
