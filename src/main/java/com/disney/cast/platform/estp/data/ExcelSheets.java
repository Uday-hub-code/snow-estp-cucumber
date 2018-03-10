package com.disney.cast.platform.estp.data;

import com.disney.cast.platform.common.data.Sheets;

public enum ExcelSheets implements Sheets {
    CONFIG,
    ALERT,
    FEATURE,
    PAYROLL,
    PERFORMANCE;

    @Override
    public int getSheetNumber() {
        return this.ordinal();
    }
}
