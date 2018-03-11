/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.estp.data;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.common.data.AbstractDataManager;
import com.disney.cast.platform.estp.api.snow.tables.AlertTableApi;
import com.disney.cast.platform.estp.api.snow.tables.model.AlertTableRecord;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author luis.martinez
 */
public class AlertDataManager extends AbstractDataManager<AlertTableApi, AlertTableRecord> {

    protected AlertDataManager() throws IOException {
        super(XLS.VACATION_PLANNER_REWARDS.get(), ExcelSheets.ALERT);
    }

    @Override
    protected AlertTableRecord postProcess(AlertTableRecord instance) throws Exception {
        return instance;
    }

    @Override
    protected TypeReference<?> getTypeReference() {
        return new TypeReference<Result<AlertTableRecord>>() {
        };
    }

    @Override
    protected AlertTableRecord processRow(Row currentRow) throws Exception {
        AlertTableRecord record = new AlertTableRecord();
        record.setUActive(String.valueOf(currentRow.getCell(0).getBooleanCellValue()));
        record.setUBody(currentRow.getCell(1).getStringCellValue());
        record.setURole(currentRow.getCell(2).getStringCellValue());
        record.setUType(currentRow.getCell(3).getStringCellValue());
        return record;
    }

    public Set<AlertTableRecord> addActive(int amount) throws Exception {
        return add(amount, (currentRow) -> {
            Cell cell = currentRow.getCell(0);
            return cell != null && cell.getBooleanCellValue() == true;
        });
    }

    public Set<AlertTableRecord> addInactive(int amount) throws Exception {
        return add(amount, (currentRow) -> {
            Cell cell = currentRow.getCell(0);
            return cell != null && cell.getBooleanCellValue() == false;
        });
    }

    @Override
    public void deleteAll() throws Exception {
        List<AlertTableRecord> alertsList = getApi()
                .get(getClient())
                .getBodyObject(new TypeReference<Result<List<AlertTableRecord>>>() {
                })
                .getResult();
        for (AlertTableRecord alert : alertsList) {
            getApi().delete(getClient(), alert.getSysId());
        }
    }

    public void delete(AlertTableRecord alert) throws Exception {
        getApi().delete(getClient(), alert.getSysId());
    }

}
