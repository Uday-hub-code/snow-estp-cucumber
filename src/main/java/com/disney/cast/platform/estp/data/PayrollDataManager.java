/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.estp.data;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.common.data.AbstractDataManager;
import com.disney.cast.platform.estp.api.snow.tables.PayrollTableApi;
import com.disney.cast.platform.estp.api.snow.tables.model.PayrollTableRecord;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author luis.martinez
 */
public class PayrollDataManager extends AbstractDataManager<PayrollTableApi, PayrollTableRecord> {

    protected PayrollDataManager() throws IOException {
        super(XLS.VACATION_PLANNER_REWARDS.get(), ExcelSheets.PAYROLL);
    }

    @Override
    protected PayrollTableRecord postProcess(PayrollTableRecord instance) throws Exception {
        return instance;
    }

    @Override
    protected TypeReference<?> getTypeReference() {
        return new TypeReference<Result<PayrollTableRecord>>() {
        };
    }

    @Override
    protected PayrollTableRecord processRow(Row currentRow) throws Exception {
        PayrollTableRecord record = new PayrollTableRecord();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime createTime = LocalDateTime.now();
        record.setUDate(formatter.format(createTime));
        record.setUCostCenterDescription(currentRow.getCell(0).getStringCellValue());
        record.setUReasonForChange(currentRow.getCell(1).getStringCellValue());
        record.setUNumber(String.valueOf(currentRow.getCell(2).getNumericCellValue()));
        record.setUCompanyCode(String.valueOf(currentRow.getCell(3).getNumericCellValue()));
        record.setUInfotype(String.valueOf(currentRow.getCell(4).getNumericCellValue()));
        record.setUIntOrder(String.valueOf(currentRow.getCell(5).getNumericCellValue()));
        record.setUWbsElement(currentRow.getCell(6).getStringCellValue());
        record.setUTextField(currentRow.getCell(7).getStringCellValue());
        record.setUDestGeo(currentRow.getCell(8).getStringCellValue());
        record.setUNetwork(currentRow.getCell(9).getStringCellValue());
        record.setUMpmIssue(currentRow.getCell(10).getStringCellValue());
        record.setUUnit(currentRow.getCell(11).getStringCellValue());
        record.setUPeriod(currentRow.getCell(12).getStringCellValue());
        record.setUActivity(currentRow.getCell(13).getStringCellValue());
        record.setUBusinessArea(String.valueOf(currentRow.getCell(14).getNumericCellValue()));
        record.setUCostCenter(String.valueOf(currentRow.getCell(15).getNumericCellValue()));
        return record;
    }

    public Set<PayrollTableRecord> addPayroll(int amount) throws Exception {
        return add(amount, (currentRow) -> {
            Cell cell = currentRow.getCell(0);
            return cell != null;
        });
    }

    @Override
    public void deleteAll() throws Exception {
        List<PayrollTableRecord> payrolls = getApi()
                .get(getClient())
                .getBodyObject(new TypeReference<Result<List<PayrollTableRecord>>>() {
                })
                .getResult();
        for (PayrollTableRecord payroll : payrolls) {
            getApi().delete(getClient(), payroll.getSysId());
        }
    }

}
